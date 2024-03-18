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

public class SuperfonAz extends LocalStore {
    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String DISCOUNT_PRICE_ELEMENT_KEY = "span[itemprop=price]";
    private final static String PRICE_ELEMENT_KEY = "div[itemprop=price]";

    private final static String PRODUCT_NAME_ELEMENT_KEY = "section.info h1";
    private final static String PRODUCT_PICTURE_KEY = "ul.splide__list li img";



    public SuperfonAz(List<String> links){
        super("SuperfonAz");
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

        Set<String> hrefList = new HashSet<>();
        for (Element srcLink : links) {
            String href = srcLink.attr("src");
            hrefList.add(href);
        }

        return hrefList;
    }

    private String getPriceElement(Document doc, String link){
        Element discountPriceElement = doc.selectFirst(DISCOUNT_PRICE_ELEMENT_KEY);

        if(discountPriceElement == null) {
            Element priceElement = doc.select(PRICE_ELEMENT_KEY).get(2);
            if(priceElement != null) {
                return priceElement.attr("content")
                        .trim()
                        .replace("₼", "");
            }

            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "price");
        }

        return discountPriceElement
                .text()
                .trim()
                .replace("₼", "");
    }

    private String getProductNameElement(Document doc, String link){
        Element productNameElement = doc.selectFirst(PRODUCT_NAME_ELEMENT_KEY);
        if(productNameElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "productName");

        return productNameElement.text().trim();
    }


//    END - Helper METHODS

}
