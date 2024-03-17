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

public class YvesrocherAz extends LocalStore {

    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();


    private final static String DISCOUNT_PRICE_ELEMENT_KEY = "sale-price.text-on-sale";
    private final static String PRICE_ELEMENT_KEY = "sale-price.text-subdued";
    private final static String PRODUCT_NAME_ELEMENT_KEY = "h1.product-title";
    private final static String PRODUCT_PICTURE_KEY = "div.product-gallery__media img";



    public YvesrocherAz(List<String> links){
        super("YvesrocherAz");
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
            hrefList.add("https://".concat(href.substring(2)));
        }

        return hrefList;
    }

    private String getPriceElement(Document doc, String link){
        Element priceElement = doc.selectFirst(DISCOUNT_PRICE_ELEMENT_KEY);
        Element discountPriceElement = doc.selectFirst(PRICE_ELEMENT_KEY);

        if(priceElement == null) {
            if(discountPriceElement == null)
                throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "price");
            else
                return discountPriceElement
                        .text()
                        .replace("Sale price", "")
                        .trim()
                        .split(" ")[0];
        }

        return priceElement.text().replace("Sale price", "").trim().split(" ")[0];
    }

    private String getProductNameElement(Document doc, String link){
        Element productNameElement = doc.selectFirst(PRODUCT_NAME_ELEMENT_KEY);
        if(productNameElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "productName");

        return productNameElement.text().trim();
    }


//    END - Helper METHODS
}
