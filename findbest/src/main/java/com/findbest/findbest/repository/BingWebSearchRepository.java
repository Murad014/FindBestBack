package com.findbest.findbest.repository;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

import com.findbest.findbest.models.SearchResultsModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;


public class BingWebSearchRepository {
    // Enter a valid subscription key.
    static String subscriptionKey = "ffd601f2f22644a49bf23b7607d12227";
    static String host = "https://api.bing.microsoft.com";
    static String path = "/v7.0/search";

    public static SearchResultsModel SearchWeb (String searchQuery,
                                                Map<String, String> params) throws Exception {

        StringBuilder paramsStr = new StringBuilder();
        for(String key: params.keySet()){
            paramsStr.append("&").append(key
                    .concat("=")
                    .concat(params.get(key)));
        }

        URL url = new URL(host + path + "?q=" +
                URLEncoder.encode(searchQuery, StandardCharsets.UTF_8) +
                paramsStr
        );

        System.out.println("TEST: " + url);

        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", subscriptionKey);


        InputStream stream = connection.getInputStream();
        String response = new Scanner(stream).useDelimiter("\\A").next();

        SearchResultsModel results = new SearchResultsModel(new HashMap<String, String>(), response);


        stream.close();
        return results;
    }

}
