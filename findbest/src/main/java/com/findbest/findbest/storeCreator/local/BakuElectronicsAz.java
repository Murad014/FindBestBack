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

public class BakuElectronicsAz extends LocalStore{

    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String PRICE_ELEMENT_KEY = ".product__price--cur";
    private final static String PRODUCT_NAME_ELEMENT_KEY = ".product__heading_desk h1";
    private final static String PRODUCT_PICTURE_KEY = "a.gallery__main-link";



    public BakuElectronicsAz(List<String> links){
        super("BakuElectronicsAz");
        this.links = List.copyOf(links);
        getInformationAndSet();
    }

    private void getInformationAndSet(){
        links.forEach(link -> {
            try {
                Document doc = Jsoup.connect(link).get();
                String getProductName = getProductNameElement(doc, link);
                String getPriceElement = getPriceElement(doc, link);
                Set<String> getProductImages = getProductImages(doc, link);

                StoreResponseDto responseDto = setResponseDto(
                        link,
                        getPriceElement,
                        getProductName,
                        CurrencyEnum.AZN,
                        getProductImages
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
    private Set<String> getProductImages(Document doc, String link) {;
        Elements links = doc.select(PRODUCT_PICTURE_KEY);
        Set<String> srcList = new HashSet<>();

        for (Element srcLink : links) {
            String src = srcLink.select("img").attr("src");
            srcList.add(pureLink(src));
        }

        return srcList;
    }

    private String getPriceElement(Document doc, String link){
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

    private String pureLink(String link){
        return "https://bakuelectronics.az/" + link;
    }


//    END - Helper METHODS
}
