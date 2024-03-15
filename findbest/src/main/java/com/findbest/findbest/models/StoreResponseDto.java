package com.findbest.findbest.models;

import com.findbest.findbest.enums.store.CurrencyEnum;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponseDto {

    private String storeName;
    private String link;
    private String productName;
    private String price;
    private CurrencyEnum currencyEnum;


}
