package com.example.storeapi.repository;

import com.example.storeapi.db.Database;
import com.example.storeapi.model.Item;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.util.List;


@Log4j2
public class RepositoryImpl implements Repository {
    private static final int EMPTY_VALUE = 0;
    private Database database;

    @Inject
    public RepositoryImpl(Database database) {
        this.database = database;
    }

    public boolean add(Item item){
        return database.addItem(item);
    }

    @Override
    public void remove(Item item){}

    @Override
    public void remove(String serialNumber){
        database.remove(serialNumber);
    }

    @Override
    public boolean isItemInWarehouse(String serialNumber){
        return database.isItemInWarehouse(serialNumber);
    }

    @Override
    public int countAllItems(){
        try{
            return Math.toIntExact(
                    database.countAllItems());
        }catch(ArithmeticException e){
            log.error(e);
            return EMPTY_VALUE;
        }
    }

    @Override
    public int countByItemType(String itemType){
        try{
            return Math.toIntExact(
                    database.countByItemType(itemType));
        }catch(IllegalArgumentException e){
            log.error(e);
            return EMPTY_VALUE;
        }catch(ArithmeticException e){
            log.error(e);
            return EMPTY_VALUE;
        }
    }

    @Override
    public List<String> findExpiredWarrantyItemsSerialNumbers(){
        return database.findExpiredWarrantyItemsSerialNumbers();
    }

}
