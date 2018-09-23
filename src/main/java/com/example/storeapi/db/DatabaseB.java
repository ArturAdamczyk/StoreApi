package com.example.storeapi.db;

import com.example.storeapi.model.Item;
import com.example.storeapi.utils.HashMapUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatabaseB implements Database{
    private ConcurrentHashMap<String,Item> items;

    private Stream<Map.Entry<String,Item>> getItemsStream(){
        return HashMapUtils.mapToStream(items);
    }

    public DatabaseB(ConcurrentHashMap<String,Item> items){
        this.items = items;
    }

    @Override
    public List<Item> getItems(){
        return Collections.list(Collections.enumeration(items.values()));
    }

    @Override
    public boolean addItem(Item item){
        return items.put(item.getSerialNumber(), item) != null;
    }

    @Override
    public void remove(String serialNumber){
        items.entrySet().removeIf(o -> o.getValue().getSerialNumber().equals(serialNumber));
    }

    @Override
    public boolean isItemInWarehouse(String serialNumber){
        return getItemsStream()
                .map(o -> o.getValue().getSerialNumber())
                .anyMatch(str -> str.equals(serialNumber));
    }

    @Override
    public long countAllItems(){
        return getItemsStream()
                .map(o -> o.getValue().getSerialNumber())
                .count();
    }

    @Override
    public long countByItemType(String itemType){
        return getItemsStream()
                .filter(it -> it.getValue().getItemType().equals(Item.ItemType.valueOf(itemType)))
                .map(o -> o.getValue().getSerialNumber())
                .count();
    }

    @Override
    public List<String> findExpiredWarrantyItemsSerialNumbers(){
        return getItemsStream()
                .filter(it -> it.getValue().isWarrantyExpired())
                .map(o -> o.getValue().getSerialNumber())
                .collect(Collectors.toList());
    }
}
