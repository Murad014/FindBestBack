package com.findbest.findbest.storeCreator.local;

import com.findbest.findbest.enums.store.CurrencyEnum;
import com.findbest.findbest.exceptions.FieldNotFoundInStoreHTMLException;
import com.findbest.findbest.models.StoreResponseDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IrshadAz extends LocalStore{
    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String PRODUCT_PICTURE_KEY = "meta[property=og:image]";



    public IrshadAz(List<String> links){
        super("IrshadAz");
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
                JSONObject productObject = getProductObject(doc, link);

                String getProductName = productObject.getString("item_name");
                String getPriceElement = String.valueOf(productObject.getDouble("price"));
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
            String href = srcLink.attr("content");
            hrefList.add(href);
        }

        return hrefList;
    }




    private static JSONObject getProductObject(Document doc, String link) {
        Elements selectJSON = doc.select("script");
        for(Element element: selectJSON){
            if(element.toString().contains("window.onload")) {
                String getJSON = element.toString()
                                .substring(
                                        element.toString().indexOf('[') + 1,
                                        element.toString().indexOf(']')
                                );

                JSONObject jsonObject = new JSONObject(getJSON);
                return jsonObject;
            }
        }

        throw new FieldNotFoundInStoreHTMLException(link, "jsonObjectOfProduct", "productObject");
    }

    private static String extractEcommerceJson(String jsonString) {
        int startIndex = jsonString.indexOf("'ecommerce':");
        int endIndex = jsonString.indexOf("};", startIndex) + 1;
        return jsonString.substring(startIndex, endIndex);
    }

//    END - Helper METHODS

}
