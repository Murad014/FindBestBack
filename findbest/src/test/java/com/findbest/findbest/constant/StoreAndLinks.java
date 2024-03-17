package com.findbest.findbest.constant;

import com.findbest.findbest.enums.store.LocalStoreEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreAndLinks {

    public static Map<LocalStoreEnum, List<String>> storeAndLinks(){
        Map<LocalStoreEnum, List<String>> storeAndLinks = new HashMap<>();

        storeAndLinks.put(
                LocalStoreEnum.BAZARSTORE_AZ,

                List.of(
                        "https://bazarstore.az/products/doymak-un-2-kq?_pos=1&_fid=e1f07ee49&_ss=c",
                        "https://bazarstore.az/products/bi%CC%87zi%CC%87m-tarla-zogal-kompotu-1-lt?pr_prod_strat=jac&pr_rec_id=720540daa&pr_rec_pid=8564540113201&pr_ref_pid=8611072049457&pr_seq=uniform"
                )
        );


        storeAndLinks.put(
                LocalStoreEnum.KONTAKT_AZ,

                List.of(
                        "https://kontakt.az/az/tozsoran-ucun-basliq-karcher-drill-dust-catcher-2-863-234-0",
                        "https://kontakt.az/az/tozsoran-ucun-firca-karcher-2-863-022-0"
                )
        );

        storeAndLinks.put(
                LocalStoreEnum.BAKUELECTRONICS_AZ,

                List.of(
                        "https://www.bakuelectronics.az/catalog/telefonlar-qadcetler/qulaqliqlar/redmi-buds-5-white.html",
                        "https://www.bakuelectronics.az/catalog/telefonlar-qadcetler/smart-saatlar/galaxy-watch-6-classic-47mm-black.html"
                )
        );

        storeAndLinks.put(
                LocalStoreEnum.UMICO_AZ,

                List.of(
                        "https://umico.az/product/376366-qrafik-planshet-vinsa-10-black",
                        "https://umico.az/product/595849-planshet-xiaomi-pad-6-8gb-256gb-gravity-gray-eu-23043rp34g"
                )
        );
        storeAndLinks.put(
                LocalStoreEnum.AZ_ORIFLAME_COM,

                List.of(
                        "https://az.oriflame.com/products/product?code=46062",
                        "https://az.oriflame.com/products/product?code=47193"                )
        );

        storeAndLinks.put(
                LocalStoreEnum.ALININO_AZ,
                List.of(
                        "https://alinino.az/product/nergiz-gulu?lang=en",
                        "https://alinino.az/product/1984-7e8af2?lang=en"

                )
        );

        storeAndLinks.put(
                LocalStoreEnum.UNIMALL_AZ,
                List.of(
                        "https://unimall.az/maybelline-mascara/",
                        "https://unimall.az/planset-lenovo-ideapad-flex-15-81ca001sus/"

                )
        );

        storeAndLinks.put(
                LocalStoreEnum.COMPSTORE_AZ,
                List.of(
                        "https://compstore.az/monoblok-lenovo-ideacentre-aio-3i-24iil5-f0fr002qrk.html",
                        "https://compstore.az/asrock-b660m-hdv-mainboard.html"

                )
        );

        storeAndLinks.put(
                LocalStoreEnum.MGSTORE_AZ,
                List.of(
                        "https://www.mgstore.az/motorola-razr-40-ultra-8-256gb-infinite-black",
                        "https://www.mgstore.az/blender-philips-hr1393-00-2-2058"

                )
        );

        storeAndLinks.put(
                LocalStoreEnum.KITABEVIM_AZ,
                List.of(
                        "https://kitabevim.az/m%C9%99hsul/akvarel-boya/",
                        "https://kitabevim.az/m%C9%99hsul/polo-uzun-askili-evrak-cantasi/",
                        "https://kitabevim.az/m%C9%99hsul/bts-1-telli-defter/"

                )
        );

        storeAndLinks.put(
                LocalStoreEnum.ALMALI_AZ,
                List.of(
                        "https://almali.az/m%C9%99hsul/sifarisl%c9%99-xiaomi-13t-8-256gb-5g-black/",
                        "https://almali.az/m%C9%99hsul/sifarisl%c9%99-sony-playstation-5-slim-1tb/"
                )
        );

        storeAndLinks.put(
                LocalStoreEnum.NEPTUN_AZ,
                List.of(
                        "https://neptun.az/ankara-makaron-burgu-neptun-online-alisveris",
                        "https://neptun.az/aguafresh-125ml-dis-macunu-otbelivanie-002472"
                )
        );

        storeAndLinks.put(
                LocalStoreEnum.OMID_AZ,
                List.of(
                        "https://omid.az/catalog/ehtiyyat_hisseleri/114942/",
                        "https://omid.az/catalog/maye%20temizleyiciler/116411/"
                )
        );

        storeAndLinks.put(
                LocalStoreEnum.BAKUBOOKCENTER_AZ,
                List.of(
                        "https://bakubookcenter.az/product/83189",
                        "https://bakubookcenter.az/product/83188"
                )
        );

        storeAndLinks.put(
                LocalStoreEnum.EMBAWOOD_AZ,
                List.of(
                        "https://embawood.az/qonaq-mebeli/masa-qonaq/cross-mexanizmli-masa",
                        "https://embawood.az/doshekler/classy-matrass-90-200"
                )
        );

        storeAndLinks.put(
            LocalStoreEnum.YVESROCHER_AZ,
            List.of(
                    "https://www.yvesrocher.az/products/28955",
                    "https://www.yvesrocher.az/products/haircare-botanical-solutions-quru-v%C9%99-z%C9%99d%C9%99l%C9%99nmi%CC%87s-saclar-ucun-b%C9%99rpaedi%CC%87ci%CC%87-kondi%CC%87si%CC%87oner-200ml"
            )
        );

        storeAndLinks.put(
                LocalStoreEnum.UNITEDSPORT_AZ,
                List.of(
                        "https://unitedsport.az/tights-cas-f038-18932.html",
                        "https://unitedsport.az/the-north-face-tanken-raglan-tee-21005.html"
                )
        );

        return storeAndLinks;
    }

}
