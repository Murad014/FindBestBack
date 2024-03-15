package com.findbest.findbest.storeCreator.local;

import com.findbest.findbest.enums.store.CurrencyEnum;
import com.findbest.findbest.models.StoreResponseDto;

import java.util.List;

public abstract class LocalStore {

    public abstract List<StoreResponseDto> response();
    final String STORE_NAME ;

    public LocalStore(String STORE_NAME){
        this.STORE_NAME = STORE_NAME;
    }

    StoreResponseDto setResponseDto(String link, String price, String productName, CurrencyEnum currency){
        StoreResponseDto responseDto = new StoreResponseDto();

        responseDto.setStoreName(STORE_NAME);
        responseDto.setProductName(productName);
        responseDto.setPrice(price);
        responseDto.setCurrencyEnum(currency);
        responseDto.setLink(link);

        return responseDto;
    }


}