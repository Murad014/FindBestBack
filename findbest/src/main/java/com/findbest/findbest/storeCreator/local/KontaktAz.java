package com.findbest.findbest.storeCreator.local;

import com.findbest.findbest.enums.store.CurrencyEnum;
import com.findbest.findbest.exceptions.FieldNotFoundInStoreHTMLException;
import com.findbest.findbest.models.StoreResponseDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KontaktAz extends LocalStore{

    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String PRICE_ELEMENT_KEY = ".prodCart__prices strong span";
    private final static String PRODUCT_NAME_ELEMENT_KEY = ".page-title span[itemprop=name]";
    private final static String STORE_NAME = "KontaktAz";



    public KontaktAz(List<String> links){
        this.links = List.copyOf(links);
        getInformationAndSet();
    }

    private void getInformationAndSet(){
        links.forEach(link -> {
            try {
                Document doc = Jsoup.connect(link).get();
                String getProductName = getProductNameElement(doc);
                String getPriceElement = getPriceElement(doc);

                StoreResponseDto responseDto = setResponseDto(
                        getPriceElement,
                        getProductName,
                        CurrencyEnum.AZN
                );
                responseDtoList.add(responseDto);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Override
    public List<StoreResponseDto> response() {
        return responseDtoList;
    }


//    PRIVATE METHODS
    private String getPriceElement(Document doc){
        Element priceElement = doc.selectFirst(PRICE_ELEMENT_KEY);
        if(priceElement == null)
            throw new FieldNotFoundInStoreHTMLException(STORE_NAME, "price");

        String purePrice = priceElement.text().trim().split(" ")[0]; // For delete last manat symbol
        return purePrice;
    }

    private String getProductNameElement(Document doc){
        Element productNameElement = doc.selectFirst(PRODUCT_NAME_ELEMENT_KEY);
        if(productNameElement == null)
            throw new FieldNotFoundInStoreHTMLException(STORE_NAME, "productName");

        return productNameElement.text().trim();
    }

    private StoreResponseDto setResponseDto(String price, String productName, CurrencyEnum currency){
        StoreResponseDto responseDto = new StoreResponseDto();

        responseDto.setStoreName(STORE_NAME);
        responseDto.setProductName(productName);
        responseDto.setPrice(price);
        responseDto.setCurrencyEnum(currency);

        return responseDto;
    }
//    END - PRIVATE METHODS
}
