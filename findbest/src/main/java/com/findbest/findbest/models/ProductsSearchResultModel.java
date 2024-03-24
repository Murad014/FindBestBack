package com.findbest.findbest.models;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsSearchResultModel {
    @Builder.Default
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private List<List<StoreResponseDto>> storeResponseDtoList;

    // Method to sort storeResponseDtoList by price ascending
    public void sortStoreResponseDtoListByPriceAscending() {
        Collections.sort(storeResponseDtoList, (list1, list2) -> {
            BigDecimal price1 = getPrice(list1);
            BigDecimal price2 = getPrice(list2);
            return price1.compareTo(price2);
        });
    }

    private BigDecimal getPrice(List<StoreResponseDto> list) {
        if (list != null && !list.isEmpty()) {
            return new BigDecimal(list.get(0).getPrice());
        }
        return BigDecimal.ZERO;
    }
}
