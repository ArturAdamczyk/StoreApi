package com.example.storeapi.api;

import java.util.List;

public interface StoreApi {
    void addItem(String serialNumber, String itemType, String warrantyExpirationDate);
    void removeItem(String serialNumber);
    boolean isItemInWarehouse(String serialNumber);
    int countAllItems();
    int countByItemType(String itemType);
    List<String> findExpiredWarrantyItemsSerialNumbers();
}
