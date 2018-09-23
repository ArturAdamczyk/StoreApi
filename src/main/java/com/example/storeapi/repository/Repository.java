package com.example.storeapi.repository;

import com.example.storeapi.model.Item;

import java.util.List;

public interface Repository extends GenericRepository<Item>{
    void remove(String serialNumber);
    boolean isItemInWarehouse(String serialNumber);
    int countAllItems();
    int countByItemType(String itemType);
    List<String> findExpiredWarrantyItemsSerialNumbers();
}
