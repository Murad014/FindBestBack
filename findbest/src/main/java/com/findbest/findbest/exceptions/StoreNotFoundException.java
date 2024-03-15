package com.findbest.findbest.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StoreNotFoundException extends RuntimeException{
    private final String storeEnum;

    public StoreNotFoundException(String storeEnum) {
        super(String.format("There is not %s store", storeEnum));
        this.storeEnum = storeEnum;
    }
}
