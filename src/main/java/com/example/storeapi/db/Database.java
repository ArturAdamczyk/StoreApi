package com.example.storeapi.db;

import com.example.storeapi.model.Item;
import java.util.List;

public interface Database {
    boolean addItem(Item item);

    void remove(String serialNumber);

    boolean isItemInWarehouse(String serialNumber);

    long countAllItems();

    long countByItemType(String itemType);

    List<String> findExpiredWarrantyItemsSerialNumbers();

    List<Item> getItems();
}
