package com.findbest.findbest.services;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

import com.findbest.findbest.entity.SearchConfig;
import com.findbest.findbest.entity.SearchConfigParams;
import com.findbest.findbest.exceptions.SearchException;
import com.findbest.findbest.models.SearchRequestModel;
import com.findbest.findbest.models.SearchResultsModel;
import com.findbest.findbest.models.WebPageModel;
import com.findbest.findbest.models.WebPagesModel;
import com.findbest.findbest.repository.SearchConfigRepository;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BingWebSearchService {
    private final SearchConfigRepository searchConfigRepository;
    private SearchConfig config;
    private final String price = " qiymət";


    @Autowired
    public BingWebSearchService(SearchConfigRepository searchConfigRepository){
        this.searchConfigRepository = searchConfigRepository;
    }




    public WebPagesModel sendSearchRequest(SearchRequestModel paramsModel) {
        this.config = searchConfigRepository.findByIsActive((byte)1);

        String searchTerm = paramsModel.getSearchKey().trim().concat(price);

        if(paramsModel.getSite() != null)
                searchTerm.concat(" site: "
                + paramsModel.getSite().trim());

        try {
            SearchResultsModel result = searchWeb(searchTerm);
            JSONObject jsonResponse = new JSONObject(result.getJsonResponse());
            JSONObject webPages = jsonResponse.getJSONObject("webPages");

            Gson gson = new Gson();
            WebPagesModel webPagesModel = gson.fromJson(webPages.toString(), WebPagesModel.class);

            JSONArray searchResult = webPages.getJSONArray("value");
            for(int i = 0; i < searchResult.length(); i++){
                Gson pageGson = new Gson();
                WebPageModel webPageModel = pageGson.fromJson(searchResult.get(i).toString(), WebPageModel.class);
                webPagesModel.getPageResultList()
                        .add(webPageModel);
            }

            return webPagesModel;
        }
        catch (Exception e) {
            throw new SearchException(
                    paramsModel.getSearchKey(),
                    paramsModel.getSite(),
                    config.getSearchConfigParamsList()
                            .stream()
                            .filter(param -> (param.getKeyOfParam().equals("count")))
                            .toList()
                            .get(0).getValueOfParam());

        }
    }


    private SearchResultsModel searchWeb(String searchQuery) throws Exception {
        StringBuilder paramsStr = new StringBuilder();

        for(SearchConfigParams param: config.getSearchConfigParamsList()) {
            paramsStr.append("&").append(param.getKeyOfParam()
                    .concat("=")
                    .concat(param.getValueOfParam()));
        }

        URL url = new URL(config.getHost() + config.getPath() + "?q=" +
                URLEncoder.encode(searchQuery, StandardCharsets.UTF_8) +
                paramsStr
        );
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", config.getSubscriptionKey());

        InputStream stream = connection.getInputStream();
        String response = new Scanner(stream).useDelimiter("\\A").next();

        SearchResultsModel results = new SearchResultsModel(new HashMap<>(), response);
        stream.close();

        return results;
    }


}
