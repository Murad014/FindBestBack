package com.findbest.findbest.storeCreator.local;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class AzOriflameCom extends LocalStore{

    private final List<String> links;
    private final List<StoreResponseDto> responseDtoList = new ArrayList<>();

    private final static String PRODUCT_KEY = "script#__NEXT_DATA__";

    public AzOriflameCom(List<String> links){
        super("AzOriflameCom");
        this.links = List.copyOf(links);
        getInformationAndSet();
    }

    private void getInformationAndSet(){
        links.forEach(link -> {
            try {
                Document doc = Jsoup.connect(link).get();
                String priceElement = doc.selectFirst(PRODUCT_KEY).html();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(priceElement);


                JsonNode productsNode = rootNode.path("props")
                        .path("pageProps")
                        .path("data")
                        .path("concept")
                        .path("products");

                JsonNode conceptNode = rootNode.path("props")
                        .path("pageProps")
                        .path("data")
                        .path("concept");


                if (productsNode.isArray()) {
                    for (JsonNode product : productsNode) {
                        String price = product.path("currentPrice").asText()
                                .trim()
                                .split(" ")[0];
                        String productName = conceptNode.path("name").asText();
                        Set<String> productImages = convertJsonArrayToSet(productsNode.get(0).path("images"));

                        StoreResponseDto responseDto = setResponseDto(
                                link,
                                price,
                                productName,
                                CurrencyEnum.AZN,
                                productImages
                        );
                        responseDtoList.add(responseDto);

                    }
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Override
    public List<StoreResponseDto> response() {
        return responseDtoList;
    }




    private static Set<String> convertJsonArrayToSet(JsonNode jsonArrayNode) {
        Set<String> resultSet = new HashSet<>();
        if (jsonArrayNode.isArray()) {
            for (JsonNode node : jsonArrayNode) {
                resultSet.add(node.asText());
            }
        }
        return resultSet;
    }

//    END - Helper METHODS
}
