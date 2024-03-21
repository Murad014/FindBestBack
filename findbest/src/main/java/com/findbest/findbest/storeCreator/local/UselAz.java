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

public class UselAz extends LocalStore{
    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String OLD_PRICE_ELEMENT_KEY = "span.old-prices";
    private final static String NEW_PRICE_ELEMENT_KEY = "span.new-prices";
    private final static String PRODUCT_NAME_ELEMENT_KEY = "div.prod_right h1";
    private final static String PRODUCT_PICTURE_KEY = "img.main_image";



    public UselAz(List<String> links){
        super("UselAz");
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
        Element newPriceElement = doc.selectFirst(NEW_PRICE_ELEMENT_KEY);
        Element oldPriceElement = doc.selectFirst(OLD_PRICE_ELEMENT_KEY);

        if(newPriceElement != null)
            return newPriceElement.text().replace("AZN", "").trim();

        if(oldPriceElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "price");

        return oldPriceElement.text().replace("AZN", "").trim();
    }

    private String getProductNameElement(Document doc, String link){
        Element productNameElement = doc.selectFirst(PRODUCT_NAME_ELEMENT_KEY);
        if(productNameElement == null)
            throw new FieldNotFoundInStoreHTMLException(link, STORE_NAME, "productName");

        return productNameElement.text().trim();
    }


//    END - Helper METHODS

}
