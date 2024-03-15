package com.findbest.findbest.storeCreator.local;

import com.findbest.findbest.enums.store.LocalStoreEnum;

import java.util.List;

public class LocalStoreCreator {

    public static LocalStore creator(LocalStoreEnum localStoreEnum,
                                     List<String> links){

        switch (localStoreEnum){
            case KONTAKT_AZ:
                return new KontaktAz(links);

            case BAKUELECTRONICS_AZ:
                return new BakuElectronicsAz(links);



        }

        throw new IllegalArgumentException("There is not this store");
    }


}
