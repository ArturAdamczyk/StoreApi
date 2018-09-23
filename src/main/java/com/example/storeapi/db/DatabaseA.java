package com.example.storeapi.db;

import com.example.storeapi.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class DatabaseA implements Database{
    private List<Item> items;

    public DatabaseA(List<Item> items){
        this.items = items;
    }

    @Override
    public List<Item> getItems(){
        return items;
    }

    @Override
    public boolean addItem(Item item){
        return items.add(item);
    }

    @Override
    public void remove(String serialNumber){
        items.removeIf(o -> o.getSerialNumber().equals(serialNumber));
    }

    @Override
    public boolean isItemInWarehouse(String serialNumber){
        return items
                .stream()
                .map(Item::getSerialNumber)
                .distinct()
                .anyMatch(str -> str.equals(serialNumber));
    }

    @Override
    public long countAllItems(){
        return items
                .stream()
                .map(Item::getSerialNumber)
                .distinct()
                .count();
    }

    @Override
    public long countByItemType(String itemType){
        return items.stream()
                .filter(it -> it.getItemType().equals(Item.ItemType.valueOf(itemType)))
                .map(Item::getSerialNumber)
                .distinct()
                .count();
    }

    @Override
    public List<String> findExpiredWarrantyItemsSerialNumbers(){
        return items.stream()
                .filter(it -> it.isWarrantyExpired())
                .map(Item::getSerialNumber)
                .distinct()
                .collect(Collectors.toList());
    }
}
