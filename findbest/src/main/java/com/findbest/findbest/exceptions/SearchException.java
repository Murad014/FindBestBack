package com.findbest.findbest.exceptions;

public class SearchException extends RuntimeException{
    private final String searchKey;
    private final String site;
    private final String count;

    public SearchException(String searchKey, String site, String count) {
        super(String.format("Searching process... Error occurred. searchKey: %s, site: %s, count: %s. ",
                searchKey,
                site,
                count));

        this.searchKey = searchKey;
        this.site = site;
        this.count = count;
    }
}
