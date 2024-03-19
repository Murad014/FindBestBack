package com.findbest.findbest.storeCreator.local;

import com.findbest.findbest.enums.store.CurrencyEnum;
import com.findbest.findbest.exceptions.FieldNotFoundInStoreHTMLException;
import com.findbest.findbest.models.StoreResponseDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AxcaAz extends LocalStore {

    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String PRICE_ELEMENT_KEY = "span.text-primary";
    private final static String PRODUCT_NAME_ELEMENT_KEY = "h1.font-extrabold";
    private final static String PRODUCT_PICTURE_KEY = "a.item.swiper-slide";



    public AxcaAz(List<String> links){
        super("AxcaAz");
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
                JSONObject productInformation = getProductInformation(doc);

                String getProductName = getProductNameElement(productInformation, link);
                String getPriceElement = getPriceElement(productInformation, link);
                Set<String> getPictures = getProductImages(productInformation, link);

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
    private Set<String> getProductImages(JSONObject productInformation, String link) {
        Set<String> images =  new HashSet<>();
        JSONArray imageArray = (JSONArray) productInformation.get("image");
        for(int i = 0; i < imageArray.length(); i++){
            images.add((String) imageArray.get(i));

        }
        return images;
    }

    private String getPriceElement(JSONObject productInformation, String link){
        JSONObject offerObject = (JSONObject) productInformation.get("offers");
        return String.valueOf(offerObject.get("price"));
    }

    private String getProductNameElement(JSONObject productInformation, String link){
        return String.valueOf(productInformation.get("name"));
    }

    private JSONObject getProductInformation(Document doc){
        String jsonScript = doc.select("script[type=application/ld+json]").get(2).html();
        JSONObject productJson = new JSONObject(jsonScript);
        return productJson;
    }


//    END - Helper METHODS


}
