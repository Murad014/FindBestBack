package com.findbest.findbest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebPagesModel {
    @JsonProperty("someResultsRemoved")
    private Boolean someResultsRemoved;

    @JsonProperty("totalEstimatedMatches")
    private int totalEstimatedMatches;

    @JsonProperty("webSearchUrl")
    private String webSearchUrl;

    @JsonProperty("value")
    @Builder.Default
    private List<WebPageModel> pageResultList = new ArrayList<>();
}
