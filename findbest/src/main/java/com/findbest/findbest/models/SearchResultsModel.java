package com.findbest.findbest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class SearchResultsModel {
    private HashMap<String, String> relevantHeaders;
    private String jsonResponse;
    public SearchResultsModel(HashMap<String, String> headers,
                              String json) {
        relevantHeaders = headers;
        jsonResponse = json;
    }



}
