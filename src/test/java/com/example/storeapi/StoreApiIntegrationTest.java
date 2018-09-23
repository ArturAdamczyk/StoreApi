package com.example.storeapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import com.example.storeapi.api.StoreApi;
import org.junit.Before;
import org.junit.Test;


import javax.inject.Inject;

public class StoreApiIntegrationTest extends BaseIntegrationTest {

    @Inject
    StoreApi api;

    @Before
    public void setUp() {
        super.setUp();
        component.inject(this);
        executeWarehouseOperations();
    }
    
    private void executeWarehouseOperations(){
        api.addItem("ABCD1234", "MOBILE_PHONE", "13/12/2016");
        api.addItem("BBBB2567", "TABLET", "22/12/2020");
        api.addItem("KMBX5522", "COMPUTER", "21/12/2020");
        api.addItem("KMBX2223", "COMPUTER", "20/12/2020");
        api.addItem("ABCD1234", "MOBILE_PHONE", "13/12/2016");
        api.addItem("FFEE4466", "TABLET", "14/10/2019");
        api.addItem("KMBX2222", "COMPUTER", "22/11/2021");
        api.addItem("CXVV9090", "MOBILE_PHONE", "03/03/2019");
        api.addItem("ASDW0001", "WATCH", "10/02/2017");
        api.addItem("GGGY8888", "TV", "22/12/2021");
        api.addItem("YYYY1129", "TV", "03/01/2024");
        api.addItem("KGGV9999", "TV", "03/01/2024");
        api.addItem("BCCC7788", "WATCH", "22/12/2021");
        api.addItem("BMXA5555", "TV", "01/01/2020");
        api.addItem("BCCC7788", "WATCH", "22/12/2021");
        api.addItem(null, null, null);
        api.addItem("ABCD1234", "MOBILE_PHONE", "21");

        api.removeItem("ABCD1234");
        api.removeItem("KGGV9999");
        api.removeItem("BMXA5555");
        api.removeItem("WDWD9990");
        api.removeItem(null);
        api.removeItem("dsfd");

    }

    @Test
    public void shouldReturnTotalNumberOfAssetsInWarehouse() {
        assertEquals(
                "Total number of items is not correct",
                10, api.countAllItems());
    }

    @Test
    public void shouldReturnTotalNumberOfComputersInWarehouse() {
        assertEquals(
                "Total number of computers is not correct",
                3, api.countByItemType("COMPUTER"));
    }

    @Test
    public void shouldReturnTotalNumberOfWatchesInWarehouse() {
        assertEquals(
                "Total number of watches is not correct",
                2, api.countByItemType("WATCH"));
    }

    @Test
    public void shouldReturnTotalNumberOfTabletsInWarehouse() {
        assertEquals(
                "Total number of tablets is not correct",
                2, api.countByItemType("TABLET"));
    }

    @Test
    public void shouldReturnTotalNumberOfMobilePhonesInWarehouse() {
        assertEquals(
                "Total number of mobile phones is not correct",
                1, api.countByItemType("MOBILE_PHONE"));
    }

    @Test
    public void shouldReturnTotalNumberOfLaptopsInWarehouse() {
        assertEquals(
                "Total number of servers is not correct",
                0, api.countByItemType("LAPTOP"));
    }

    @Test
    public void shouldReturnTotalNumberOfTvsInWarehouse() {
        assertEquals(
                "Total number of tvs is not correct",
                2, api.countByItemType("TV"));
    }

    @Test
    public void shouldFindAssetInWarehouse() {
        assertTrue(
                "Item should be found in warehouse",
                api.isItemInWarehouse("YYYY1129"));
    }

    @Test
    public void shouldFindExpiredWarrantyAssetsSerialNumbers() {
        List<String> expiredWarrantyAssetsSerialNumbers = api.findExpiredWarrantyItemsSerialNumbers();
        assertEquals(
                "Number of items with expired warranty is not correct",
                1, expiredWarrantyAssetsSerialNumbers.size());
        assertEquals(
                "Expired warranty asset serial number is not correct",
                "ASDW0001", expiredWarrantyAssetsSerialNumbers.get(0));
    } 
     
}
