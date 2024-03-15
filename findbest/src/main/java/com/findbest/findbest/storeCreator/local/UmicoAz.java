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

public class UmicoAz extends LocalStore{

    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String PRICE_ELEMENT_KEY =
            ".MPProductMainDesc-OfferPrice span span[data-info=item-desc-price-old]";
    private final static String DISCOUNT_PRICE_ELEMENT_KEY =
            ".TimerProduct span span span[data-info=item-desc-price-new]";
    private final static String PRODUCT_NAME_ELEMENT_KEY = ".MPProductMainDesc h1[itemprop=name]";
    private final static String STORE_NAME = "UmicoAz";



    public UmicoAz(List<String> links){
        this.links = List.copyOf(links);
        getInformationAndSet();
    }

    private void getInformationAndSet(){
        links.forEach(link -> {
            try {
                Document doc = Jsoup.connect(link).get();
                String getProductName = getProductNameElement(doc, link);
                String getPriceElement = getPriceElement(doc, link);

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


    //    Helper METHODS
    private String getPriceElement(Document doc, String link){
        // First Look the discount price exists
        Element discountPriceElement = doc.selectFirst(DISCOUNT_PRICE_ELEMENT_KEY);
        if(discountPriceElement != null)
            return discountPriceElement.text().trim().split(" ")[0];

        // Then look for old price
        Element priceElement = doc.selectFirst(PRICE_ELEMENT_KEY);
        if(priceElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "price");

        return priceElement.text().trim().split(" ")[0];
    }

    private String getProductNameElement(Document doc, String link){
        Element productNameElement = doc.selectFirst(PRODUCT_NAME_ELEMENT_KEY);
        if(productNameElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "productName");

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
//    END - Helper METHODS
}
