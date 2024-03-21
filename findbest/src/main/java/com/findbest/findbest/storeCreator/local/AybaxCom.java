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

public class AybaxCom extends LocalStore{

    private static final String BASE_URL = "https://aybax.com";
    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String PRICE_ELEMENT_KEY = "[style=font-size: 1.5rem; font-weight: bold;]";
    private final static String PRODUCT_NAME_ELEMENT_KEY = "div.col-12 h3.text-muted";
    private final static String PRODUCT_PICTURE_KEY = "div.swiper-slide";



    public AybaxCom(List<String> links){
        super("AybaxCom");
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
        Elements links = doc.select(PRODUCT_PICTURE_KEY);
        String styleAttribute = links.attr("style");

        // Extract the URL from the style attribute
        String imageUrl = styleAttribute.substring(styleAttribute.indexOf("url(") + 4, styleAttribute.indexOf(")"));

        Set<String> images = new HashSet<>();
        images.add(BASE_URL.concat(imageUrl.substring(1, imageUrl.length() - 1)));
        return images;
    }

    private String getPriceElement(Document doc, String link){
        Element priceElement = doc.selectFirst(PRICE_ELEMENT_KEY);
        if(priceElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "price");

        return priceElement.text().replace("AZN", "").trim();
    }

    private String getProductNameElement(Document doc, String link){
        Element productNameElement = doc.selectFirst(PRODUCT_NAME_ELEMENT_KEY);
        if(productNameElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "productName");

        return productNameElement.text().trim();
    }


//    END - Helper METHODS

}
