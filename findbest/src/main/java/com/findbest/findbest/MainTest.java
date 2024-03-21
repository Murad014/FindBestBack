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

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://az.oriflame.com/products/product?code=46062",
//                        "https://az.oriflame.com/products/product?code=47193"
//
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://alinino.az/product/nergiz-gulu?lang=en",
//                        "https://alinino.az/product/1984-7e8af2?lang=en"
//
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://maxi.az/telefonlar-ve-plansetler/telefonlar/smartfonlar/xiaomi-redmi-12-nfc-4gb-128gb-silver/"
//
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://unimall.az/maybelline-mascara/",
//                        "https://unimall.az/planset-lenovo-ideapad-flex-15-81ca001sus/",
//                        "https://unimall.az/iphone-12-64gb-black/"
//
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://compstore.az/monoblok-lenovo-ideacentre-aio-3i-24iil5-f0fr002qrk.html",
//                        "https://compstore.az/asrock-b660m-hdv-mainboard.html"
//
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://www.mgstore.az/motorola-razr-40-ultra-8-256gb-infinite-black",
//                        "https://www.mgstore.az/blender-philips-hr1393-00-2-2058"
//
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://kitabevim.az/m%C9%99hsul/akvarel-boya/",
//                        "https://kitabevim.az/m%C9%99hsul/polo-uzun-askili-evrak-cantasi/",
//                        "https://kitabevim.az/m%C9%99hsul/bts-1-telli-defter/"
//
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://almali.az/m%C9%99hsul/sifarisl%c9%99-xiaomi-13t-8-256gb-5g-black/",
//                        "https://almali.az/m%C9%99hsul/sifarisl%c9%99-sony-playstation-5-slim-1tb/"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://omid.az/catalog/ehtiyyat_hisseleri/114942/",
//                        "https://omid.az/catalog/maye%20temizleyiciler/116411/"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://bakubookcenter.az/product/83189",
//                        "https://bakubookcenter.az/product/83188"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://embawood.az/qonaq-mebeli/masa-qonaq/cross-mexanizmli-masa",
//                        "https://embawood.az/doshekler/classy-matrass-90-200"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://santral.az/az/products/sm410-beton-kesen-misar-400mm-cedima-10888/",
//                        "https://santral.az/az/products/9833-formaveren-gardena-31254"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://www.yvesrocher.az/products/28955",
//                        "https://www.yvesrocher.az/products/haircare-botanical-solutions-quru-v%C9%99-z%C9%99d%C9%99l%C9%99nmi%CC%87s-saclar-ucun-b%C9%99rpaedi%CC%87ci%CC%87-kondi%CC%87si%CC%87oner-200ml"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://unitedsport.az/tights-cas-f038-18932.html",
//                        "https://unitedsport.az/the-north-face-tanken-raglan-tee-21005.html"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://www.bodycare.az/balmy-dirnaq-tutan-regular.html",
//                        "https://www.bodycare.az/farmstay-ilbiz-soku-gez-kremi.html"
//                )
//        );
//
//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://gosport.az/az/adidas-own-the-run-kopu-onlu-yungul-god-kc-fl6964",
//                        "https://gosport.az/az/skechers-bobs-bamina-2-qadinlar-ucun-ayaqqabi-117362-wbmt"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://life-sport.az/product/az/26/l-arginine-100-kapsul",
//                        "https://life-sport.az/product/az/312/caffeine-kick-60-capsules"
//                )
//        );
//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://novella.az/kitab/boyuk-dordluk",
//                        "https://novella.az/kitab/maliyyenin-esaslari"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://emsan.com.az/serwant-home-kapitoneli-yastik-5070-ag-p-635bd8df249eb21e1b112246",
//                        "https://emsan.com.az/homend-cooltouch-1619h-kettle-p-64f829445bba9e5b75911563"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://evimizstore.az/metbex/palermo-saxlama-qabi-500-ml-3-ed-27562",
//                        "https://evimizstore.az/metbex/saxlama-qabi-sugarspice-neo-luxe-27058"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://biotus.az/az/biotin-biotin-biotus-10000-mkg-100-kapsul.html",
//                        "https://biotus.az/az/maslo-vechernej-primuly-s-glk-evening-primrose-oil-puritan-s-pride-500-mg-100-gelevyh-kapsul.html"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://madeyra.com/index.php?route=product/product&product_id=835",
//                        "https://madeyra.com/remi-yataq-desti"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://decoria.az/az/p/6668/bosch-su-filteri",
//                        "https://decoria.az/az/p/928447/dosekceli-rattan-sezlonq-195x65x32sm-042280230",
//                        "https://decoria.az/az/p/16806/tort-standi-33sm-a12210000"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://www.libraff.az/kitab/bdii-dbiyyat/romanlar-and-novellalar/portaal-ba/",
//                        "https://www.libraff.az/aksiya/sara-dessen-set/"
//                )
//        );


//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://www.elitoptimal.az/Acer-Aspire-A315-59G-5283-NX-K6WER-008",
//                        "https://www.elitoptimal.az/Komputer-texnikasi/Komputer-ve-ofis-avadanliqlari/Sebeke-avadanliqlari/Hub-Defender-Quadro-Universal-USB-Black"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://tekerstore.az/teker-satisi/nexen-n-fera-su1-215-45-r17-91w",
//                        "https://tekerstore.az/teker-satisi/bridgestone-psport-265-40-r20-104y"
//                )
//        );
//
//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://proteinshop.az/products/lipo-6-black-ultra-concentrate-60caps",
//                        "https://proteinshop.az/products/gaspari-aminomax-8000-325tab"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://www.superfon.az/az/products/hediyye-karti-50-azn-106022",
//                        "https://www.superfon.az/az/products/simsiz-wireless-zengli-saat-103739",
//                        "https://www.superfon.az/az/products/qulaqliq-bt-jokade-ji011-blue-106417"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://www.saraltech.store/MF453dw",
//                        "https://www.saraltech.store/components/Anker-A8383"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://axca.az/qiziloba-5-mertebeli-demir-laminant-ref",
//                        "https://axca.az/axca-taxta-dsmal-asqi-refi"
//                )
//        );


//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://topbrands.az/14-870.html",
//                        "https://topbrands.az/baseus-c2-tozsoran.html"
//                )
//        );

//        List<String> links = new ArrayList<>(
//                List.of(
//                        "https://avon.az/product/makeup/makeup-lips/makeup-lips-gloss/9999916"
//                )
//        );

        List<String> links = new ArrayList<>(
                List.of(
                        "https://lekal.az/index.php?route=product/product&product_id=25403",
                        "https://lekal.az/index.php?route=product/product&product_id=23665"
                )
        );


        LocalStore bakuE = LocalStoreCreator.creator(LocalStoreEnum.LEKAL_AZ, links);


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
