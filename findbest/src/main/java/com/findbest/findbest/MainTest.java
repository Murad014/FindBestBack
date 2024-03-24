package com.findbest.findbest;

import com.findbest.findbest.enums.store.LocalStoreEnum;
import com.findbest.findbest.models.SearchRequestModel;
import com.findbest.findbest.models.SearchResultsModel;
import com.findbest.findbest.models.StoreResponseDto;
import com.findbest.findbest.storeCreator.local.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class MainTest {
    public static void main(String... args){
        List<String> links = new ArrayList<>(
                List.of("https://ispace.az/tv/apple-tv-4k/apple-tv-4k-64-gb-mn873rua")
        );

        LocalStore store = LocalStoreCreator.creator(LocalStoreEnum.IRSHAD_AZ, links);


        for(StoreResponseDto res: store.response()){
            System.out.println(res);
        }
    }





}
