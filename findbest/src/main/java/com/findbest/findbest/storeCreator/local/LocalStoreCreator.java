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

        }

        throw new StoreNotFoundException(localStoreEnum.toString());
    }


}
