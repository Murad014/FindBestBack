package com.findbest.findbest.models;

import com.findbest.findbest.enums.store.CurrencyEnum;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponseDto {

    private String storeName;
    private String link;
    private Set<String> images;
    private String productName;
    private String price;
    private CurrencyEnum currencyEnum;


}
