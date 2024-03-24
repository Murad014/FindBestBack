package com.findbest.findbest.services;

import com.findbest.findbest.enums.store.LocalStoreEnum;
import com.findbest.findbest.models.*;
import com.findbest.findbest.storeCreator.local.LocalStore;
import com.findbest.findbest.storeCreator.local.LocalStoreCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductSearchService {

    private final BingWebSearchService bingWebSearchService;
    private final HashMap<LocalStoreEnum, List<String>> mem = new HashMap<>();


    @Autowired
    public ProductSearchService(BingWebSearchService bingWebSearchService){
        this.bingWebSearchService = bingWebSearchService;
    }

    public ProductsSearchResultModel getProducts(SearchRequestModel searchRequestModel) throws MalformedURLException {
        mem.clear();

        // Get data from BING and collect
        collectStore(searchRequestModel);

        // Create Response
        ProductsSearchResultModel response = new ProductsSearchResultModel();

        for(LocalStoreEnum storeEnum: mem.keySet()){
            try {
                LocalStore localStore = LocalStoreCreator
                        .creator(storeEnum, mem.get(storeEnum));
                if(response.getStoreResponseDtoList() == null)
                    response.setStoreResponseDtoList(
                            new ArrayList<>(List.of(localStore.response()))
                    );
                else
                    response.getStoreResponseDtoList().add(localStore.response());

            } catch (Exception exp){
                System.out.println(exp.getMessage());
            }

        }

        response.sortStoreResponseDtoListByPriceAscending();
        return response;
    }

//    HELPER METHODS

    private void collectStore(SearchRequestModel searchRequestModel) throws MalformedURLException {
        WebPagesModel webPagesModel = bingWebSearchService.sendSearchRequest(searchRequestModel);

        for(WebPageModel page: webPagesModel.getPageResultList()){
            URL url = new URL(page.getUrl());
            String hostName = trimWWW(url.getHost());
            LocalStoreEnum store = LocalStoreEnum.getByHostname(hostName);
            if(store != null) {
                if(mem.get(store) == null) {
                    mem.put(store, new ArrayList<>(
                            List.of(page.getUrl())
                    ));
                }else{
                    mem.get(store).add(page.getUrl());
                }
            }
        }
    }

    private String trimWWW(String hostname){
        if(hostname.toLowerCase().startsWith("www.")){
            return hostname.substring(4);
        }
        return hostname;
    }

//    END - HELPER METHODS


}
