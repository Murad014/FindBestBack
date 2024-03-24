package com.findbest.findbest.storeCreator.local;

import com.findbest.findbest.enums.store.LocalStoreEnum;
import com.findbest.findbest.exceptions.StoreNotFoundException;

import java.util.List;

public class LocalStoreCreator {

    public static LocalStore creator(LocalStoreEnum localStoreEnum,
                                     List<String> links){

        switch (localStoreEnum) {
            case KONTAKT_AZ -> {
                return new KontaktAz(links);
            }
            case UMICO_AZ -> {
                return new UmicoAz(links);
            }
            case BAKUELECTRONICS_AZ -> {
                return new BakuElectronicsAz(links);
            }
            case BAZARSTORE_AZ -> {
                return new BazarStoreAz(links);
            }
            case AZ_ORIFLAME_COM -> {
                return new AzOriflameCom(links);
            }
            case ALININO_AZ -> {
                return new AlininoAz(links);
            }
            case UNIMALL_AZ -> {
                return new UnimallAz(links);
            }
            case COMPSTORE_AZ -> {
                return new CompstoreAz(links);
            }
            case MGSTORE_AZ -> {
                return new MgStoreAz(links);
            }
            case KITABEVIM_AZ -> {
                return new KitabEvimAZ(links);
            }
            case ALMALI_AZ -> {
                return new AlmaliAz(links);
            }
            case NEPTUN_AZ -> {
                return new NeptunAz(links);
            }
            case OMID_AZ -> {
                return new OmidAz(links);
            }
            case BAKUBOOKCENTER_AZ -> {
                return new BakuBookCenter(links);
            }
            case EMBAWOOD_AZ -> {
                return new EmbawoodAz(links);
            }

            case YVESROCHER_AZ -> {
                return new YvesrocherAz(links);
            }

            case UNITEDSPORT_AZ -> {
                return new UnitedsportAz(links);
            }

            case BODYCARE_AZ -> {
                return new BodycareAz(links);
            }

            case GOSPORT_AZ -> {
                return new GoSportAz(links);
            }

            case LIFE_SPORT_AZ -> {
                return new LifeSportAz(links);
            }

            case SAATSTORE_AZ -> {
                return new SaatStoreAz(links);
            }


            case NOVELLA_AZ -> {
                return new NovellaAz(links);
            }

            case EMSAN_COM_AZ -> {
                return new EmsanComAz(links);
            }

            case EVIMIZSTORE_AZ -> {
                return new EvimizStoreAz(links);
            }

            case BIOTUS_AZ -> {
                return new BiotusAz(links);
            }

            case MADEYRA_COM -> {
                return new MadeyraCom(links);
            }

            case DECORIA_AZ -> {
                return new DecoriaAZ(links);
            }

            case LIBRAFF_AZ -> {
                return new LibraffAz(links);
            }

            case OPTIMAL_AZ -> {
                return new OptimalAz(links);
            }

            case TEKERSTORE_AZ -> {
                return new TekerStoreAz(links);
            }

            case PROTEINSHOP_AZ -> {
                return new ProteinshopAz(links);
            }

            case SUPERFON_AZ -> {
                return new SuperfonAz(links);
            }

            case SARALTECH_STORE -> {
                return new SaralTechStore(links);
            }

            case AXCA_AZ -> {
                return new AxcaAz(links);
            }

            case TOPBRANDS_AZ -> {
                return new TopBrandsAz(links);
            }

            case ALIN_AZ -> {
                return new AlinAz(links);
            }

            case AYBAX_COM -> {
                return new AybaxCom(links);
            }

            case TIMSPORT_AZ -> {
                return new TimsportAz(links);
            }

            case ARIZON_AZ -> {
                return new ArizonAz(links);
            }

            case BUTALI_AZ -> {
                return new ButaliAz(links);
            }

            case DINO_AZ -> {
                return new DinoAz(links);
            }

            case VOLKSSPORT_AZ -> {
                return new VolkssportAz(links);
            }

            case USEL_AZ -> {
                return new UselAz(links);
            }

            case REALBUY_AZ -> {
                return new RealBuyAz(links);
            }

            case OFISAIT_AZ -> {
                return new OfisaitAz(links);
            }

            case HAMISIBURADA_AZ -> {
                return new HamisiburadaAz(links);
            }

            case SUPREMEBEL_AZ -> {
                return new SupremebelAz(links);
            }

            case ERAELECTRONICS_AZ -> {
                return new EraelectronicsAz(links);
            }

            case ASANGUL_COM -> {
                return new AsangulCom(links);
            }

            case ANTARIS_AZ -> {
                return new AntarisAz(links);
            }

            case GALLERY_AZ -> {
                return new GalleryAz(links);
            }

            case BONPOPPY_AZ -> {
                return new BonpoppyAz(links);
            }

            case YUMROO_AZ -> {
                return new YumrooAz(links);
            }

            case CINARYAYIMLARI_COM -> {
                return new CinarYayimlariAz(links);
            }

            case ALSEVIN_AZ -> {
                return new AlsevinAz(links);
            }

            case DUAL_AZ -> {
                return new DualAz(links);
            }

            case LEKAL_AZ -> {
                return new LekalAz(links);
            }

            case QANUN_AZ -> {
                return new QanunAz(links);
            }

            case BOOKMART_AZ -> {
                return new BookMartAz(links);
            }
            case IRSHAD_AZ -> {
                return new IrshadAz(links);
            }
        }

        throw new StoreNotFoundException(localStoreEnum.toString());
    }


}
