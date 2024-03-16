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

        }

        throw new StoreNotFoundException(localStoreEnum.toString());
    }


}
