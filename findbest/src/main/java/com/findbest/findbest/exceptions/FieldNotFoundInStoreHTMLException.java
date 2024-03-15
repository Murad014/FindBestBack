package com.findbest.findbest.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FieldNotFoundInStoreHTMLException extends RuntimeException{
    private final String resourceName;
    private final String fieldName;
    private final String resourceLink;

    public FieldNotFoundInStoreHTMLException(String resourceLink, String resourceName, String fieldName) {
        super(String.format("%s not found with %s : %s", resourceLink, resourceName, fieldName));
        this.resourceLink = resourceLink;
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
