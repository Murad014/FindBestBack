package com.findbest.findbest.storeCreator;

import com.findbest.findbest.constant.StoreAndLinks;
import com.findbest.findbest.enums.store.CurrencyEnum;
import com.findbest.findbest.enums.store.LocalStoreEnum;
import com.findbest.findbest.models.StoreResponseDto;
import com.findbest.findbest.storeCreator.local.BazarStoreAz;
import com.findbest.findbest.storeCreator.local.LocalStore;
import com.findbest.findbest.storeCreator.local.LocalStoreCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StoreCreatorTest {
    private static Map<LocalStoreEnum, List<String>> storeAndLinks;
    
    @BeforeAll
    public static void beforeAll(){
        storeAndLinks = StoreAndLinks.storeAndLinks();        
    }

    @DisplayName("Test store: {0}")
    @ParameterizedTest(name = "{index} - {0}")
    @EnumSource(LocalStoreEnum.class)
    void testStoreWithCustomDisplayName(LocalStoreEnum storeEnum) {
        testStore(storeEnum);
    }


    @ParameterizedTest
    @EnumSource(LocalStoreEnum.class)
    @Disabled
    void testStore(LocalStoreEnum storeEnum) {
        List<String> links = storeAndLinks.get(storeEnum);

        LocalStore store = LocalStoreCreator.creator(storeEnum, links);

        List<StoreResponseDto> response = store.response();

        assertNotNull(response);
        assertFalse(response.isEmpty());

        for (StoreResponseDto dto : response) {
            assertNotNull(dto.getLink());
            assertNotNull(dto.getPrice());
            assertTrue(Double.valueOf(dto.getPrice().replace(",", "")) > 0);
            assertNotNull(dto.getProductName());
            assertNotNull(dto.getCurrencyEnum());
            assertNotNull(dto.getImages());

            if(checkSpecials(storeEnum))
                assertFalse(dto.getImages().isEmpty());

            assertEquals(CurrencyEnum.AZN, dto.getCurrencyEnum());
        }
    }


    

    private boolean checkSpecials(LocalStoreEnum localStoreEnum){
        return !localStoreEnum.equals(LocalStoreEnum.SUPERFON_AZ)
                && !localStoreEnum.equals(LocalStoreEnum.SARALTECH_STORE);
    }

}
