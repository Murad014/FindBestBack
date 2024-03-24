package com.findbest.findbest.enums.store;
import java.util.HashMap;
import java.util.Map;
public enum LocalStoreEnum {
//    MAXI_AZ("maxi.az"),
//    ISPACE_AZ("ispace.az"),

    KONTAKT_AZ("kontakt.az"),
    BAKUELECTRONICS_AZ("bakuelectronics.az"),
    UMICO_AZ("umico.az"),
    IRSHAD_AZ("irshad.az"),
    BAZARSTORE_AZ("bazarstore.az"),
    AZ_ORIFLAME_COM("az.oriflame.com"),
    ALININO_AZ("alinino.az"),
    UNIMALL_AZ("unimall.az"),
    COMPSTORE_AZ("compstore.az"),
    MGSTORE_AZ("mgstore.az"),
    KITABEVIM_AZ("kitabevim.az"),
    ALMALI_AZ("almali.store"),
    NEPTUN_AZ("neptun.az"),
    OMID_AZ("omid.az"),
    BAKUBOOKCENTER_AZ("bakubookcenter.az"),
    EMBAWOOD_AZ("embawood.az"),
    YVESROCHER_AZ("yvesrocher.az"),
    UNITEDSPORT_AZ("unitedsport.az"),
    BODYCARE_AZ("bodycare.az"),
    GOSPORT_AZ("gosport.az"),
    LIFE_SPORT_AZ("life-sport.az"),
    SAATSTORE_AZ("saatstore.az"),
    NOVELLA_AZ("novella.az"),
    EMSAN_COM_AZ("emsan.com.az"),
    EVIMIZSTORE_AZ("evimizstore.az"),
    BIOTUS_AZ("biotus.az"),
    MADEYRA_COM("madeyra.com"),
    DECORIA_AZ("decoria.az"),
    LIBRAFF_AZ("libraff.az"),
    OPTIMAL_AZ("optimal.az"),
    TEKERSTORE_AZ("tekerstore.az"),
    PROTEINSHOP_AZ("proteinshop.az"),
    SUPERFON_AZ("superfon.az"),
    SARALTECH_STORE("saraltech.store"),
    AXCA_AZ("axca.az"),
    TOPBRANDS_AZ("topbrands.az"),
    ALIN_AZ("alin.az"),
    AYBAX_COM("aybax.com"),
    TIMSPORT_AZ("timsport.az"),
    ARIZON_AZ("arizon.az"),
    BUTALI_AZ("butali.az"),
    DINO_AZ("dino.az"),
    VOLKSSPORT_AZ("volkssport.az"),
    USEL_AZ("usel.az"),
    REALBUY_AZ("realbuy.az"),
    OFISAIT_AZ("ofisait.az"),
    HAMISIBURADA_AZ("hamisiburada.az"),
    SUPREMEBEL_AZ("supremebel.az"),
    ERAELECTRONICS_AZ("eraelectronics.az"),
    ASANGUL_COM("asangul.com"),
    ANTARIS_AZ("antaris.az"),
    GALLERY_AZ("gallery.az"),
    BONPOPPY_AZ("bonpoppy.az"),
    YUMROO_AZ("yumroo.az"),
    CINARYAYIMLARI_COM("cinaryayimlari.com"),
    ALSEVIN_AZ("alsevin.az"),
    DUAL_AZ("dual.az"),
    LEKAL_AZ("lekal.az"),
    BOOKMART_AZ("bookmart.az"),
    QANUN_AZ("qanun.az");

    private static final Map<String, LocalStoreEnum> stringToEnum = new HashMap<>();

    static {
        for (LocalStoreEnum value : values()) {
            stringToEnum.put(value.stringValue, value);
        }
    }

    private final String stringValue;

    LocalStoreEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    public static LocalStoreEnum fromString(String stringValue) {
        return stringToEnum.get(stringValue);
    }

    public String getStringValue() {
        return stringValue;
    }

    // New method to search for enum by hostname
    public static LocalStoreEnum getByHostname(String hostname) {
        for (LocalStoreEnum value : values()) {
            if (value.stringValue.equalsIgnoreCase(hostname)) {
                return value;
            }
        }
        return null; // If hostname not found
    }
}
