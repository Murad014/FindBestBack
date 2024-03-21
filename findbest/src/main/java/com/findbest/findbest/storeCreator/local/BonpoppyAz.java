package com.findbest.findbest.storeCreator.local;


import com.findbest.findbest.enums.store.CurrencyEnum;
import com.findbest.findbest.exceptions.FieldNotFoundInStoreHTMLException;
import com.findbest.findbest.models.StoreResponseDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BonpoppyAz extends LocalStore {
    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String PRICE_ELEMENT_KEY = "p.price ins span.woocommerce-Price-amount bdi";
    private final static String OLD_PRICE_ELEMENT_KEY = "p.price span.woocommerce-Price-amount bdi";
    private final static String PRODUCT_NAME_ELEMENT_KEY = "h1.product_title";
    private final static String PRODUCT_PICTURE_KEY = "div.product-image-wrap figure a img";



    public BonpoppyAz(List<String> links){
        super("BonpoppyAz");
        this.links = List.copyOf(links);
        getInformationAndSet();
    }


    @Override
    public List<StoreResponseDto> response() {
        return responseDtoList;
    }

    private void getInformationAndSet(){
        links.forEach(link -> {
            try {
                Document doc = Jsoup.connect(link).get();
                String getProductName = getProductNameElement(doc, link);
                String getPriceElement = getPriceElement(doc, link);
                Set<String> getPictures = getProductImages(doc, link);

                StoreResponseDto responseDto = setResponseDto(
                        link,
                        getPriceElement,
                        getProductName,
                        CurrencyEnum.AZN,
                        getPictures
                );
                responseDtoList.add(responseDto);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //    Helper METHODS
    private Set<String> getProductImages(Document doc, String link) {
        Elements srcLink = doc.select(PRODUCT_PICTURE_KEY);
        Set<String> hrefList = new HashSet<>();
        String href = srcLink.attr("data-large_image");
        hrefList.add(href);

        return hrefList;
    }

    private String getPriceElement(Document doc, String link){
        Element priceElement = doc.selectFirst(PRICE_ELEMENT_KEY);
        Element oldPriceElement = doc.selectFirst(OLD_PRICE_ELEMENT_KEY);
        if(priceElement != null)
            return priceElement.text().replace("₼", "").trim();

        if(oldPriceElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "productName");

        return oldPriceElement.text().replace("₼", "").trim();

    }

    private String getProductNameElement(Document doc, String link){
        Element productNameElement = doc.selectFirst(PRODUCT_NAME_ELEMENT_KEY);
        if(productNameElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "productName");

        return productNameElement.text().trim();
    }


//    END - Helper METHODS

}
