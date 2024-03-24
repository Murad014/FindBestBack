package com.findbest.findbest.models;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestModel {
    private String searchKey;

    private String site;

    public SearchRequestModel(String searchKey){
        this.searchKey = searchKey;
    }

//    @Builder.Default
//    private String count = "10";
//    @Builder.Default
//    private String textFormat="HTML";
//    @Builder.Default
//    private String textDecorations = "True";
}
