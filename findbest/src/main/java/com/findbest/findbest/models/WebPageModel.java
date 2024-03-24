package com.findbest.findbest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WebPageModel {

    @JsonProperty("displayUrl")
    private String displayUrl;

    @JsonProperty("snippet")
    private String snippet;

    @JsonProperty("isNavigational")
    private boolean isNavigational;

    @JsonProperty("cachedPageUrl")
    private String cachedPageUrl;

    @JsonProperty("noCache")
    private boolean noCache;

    @JsonProperty("isFamilyFriendly")
    private boolean isFamilyFriendly;

    @JsonProperty("name")
    private String name;

    @JsonProperty("dateLastCrawled")
    private String dateLastCrawled;

    @JsonProperty("language")
    private String language;

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;
}
