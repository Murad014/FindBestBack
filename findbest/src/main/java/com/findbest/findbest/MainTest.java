package com.findbest.findbest;

import com.findbest.findbest.enums.store.LocalStoreEnum;
import com.findbest.findbest.models.SearchResultsModel;
import com.findbest.findbest.models.StoreResponseDto;
import com.findbest.findbest.storeCreator.local.KontaktAz;
import com.findbest.findbest.storeCreator.local.LocalStore;
import com.findbest.findbest.storeCreator.local.LocalStoreCreator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

import static com.findbest.findbest.repository.BingWebSearchRepository.SearchWeb;
public class MainTest {
    public static void main(String... args){
//
//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://kontakt.az/az/iphone-15-pro-512-gb-blue",
//                        "https://kontakt.az/az/qulaqliq-urbanista-san-francisco-dark-clown-18535",
//                        "https://kontakt.az/az/tozsoran-ucun-basliq-karcher-drill-dust-catcher-2-863-234-0",
//                        "https://kontakt.az/az/tozsoran-ucun-firca-karcher-2-863-022-0"
//                )
//        );

//        LocalStore kontakt = LocalStoreCreator.creator(LocalStoreEnum.KONTAKT_AZ, links);



//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://umico.az/product/376366-qrafik-planshet-vinsa-10-black",
//                        "https://umico.az/product/595849-planshet-xiaomi-pad-6-8gb-256gb-gravity-gray-eu-23043rp34g"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://www.bakuelectronics.az/catalog/telefonlar-qadcetler/qulaqliqlar/redmi-buds-5-white.html",
//                        "https://www.bakuelectronics.az/catalog/telefonlar-qadcetler/smart-saatlar/galaxy-watch-6-classic-47mm-black.html"
//                )
//        );


//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://bazarstore.az/products/doymak-un-2-kq?_pos=1&_fid=e1f07ee49&_ss=c",
//                        "https://bazarstore.az/products/bi%CC%87zi%CC%87m-tarla-zogal-kompotu-1-lt?pr_prod_strat=jac&pr_rec_id=720540daa&pr_rec_pid=8564540113201&pr_ref_pid=8611072049457&pr_seq=uniform"
//
//                )
//        );

        List<String> links = new ArrayList<>(
                List.of(
                        "https://az.oriflame.com/products/product?code=46062",
                        "https://az.oriflame.com/products/product?code=47193"

                )
        );

        LocalStore bakuE = LocalStoreCreator.creator(LocalStoreEnum.AZ_ORIFLAME_COM, links);


        for(StoreResponseDto response: bakuE.response())
            System.out.println(response);
    }



    private void sendSearchRequest(){
        String searchTerm = "Samsung A54 qiymet";
        Map<String, String> params = new HashMap<>();
        params.put("count", "1");
        params.put("textFormat", "HTML");
        params.put("textDecorations", "True");
        params.put("count", "1");

        // Call the SearchWeb method and print the response.
        try {
            SearchResultsModel result = SearchWeb(searchTerm, params);

            JSONObject jsonResponse = new JSONObject(result.getJsonResponse());
            JSONObject webPages = jsonResponse.getJSONObject("webPages");
            JSONArray value = webPages.getJSONArray("value");
            System.out.println(value.get(1));

        }
        catch (Exception e) {
            e.printStackTrace(System.out);
            System.exit(1);
        }
    }







}
