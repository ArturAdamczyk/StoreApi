package com.example.storeapi;

import com.example.storeapi.db.Database;
import com.example.storeapi.repository.RepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryUnitTest {

    @Mock
    private Database database;

    private RepositoryImpl repository;

    @Before
    public void setUp() {
       MockitoAnnotations.initMocks(this);
       repository = new RepositoryImpl(database);
    }

    @Test
    public void shouldFindExpiredWarrantyItems() {
        repository.findExpiredWarrantyItemsSerialNumbers();
        Mockito.verify(database).findExpiredWarrantyItemsSerialNumbers();
    }

    @Test
    public void shouldReturnTotalNumberOfItems(){
        repository.countAllItems();
        Mockito.verify(database).countAllItems();
    }

    @Test
    public void shouldReturnTotalNumberOfTablets(){
        repository.countByItemType("TABLET");
        Mockito.verify(database).countByItemType("TABLET");
    }

    @Test
    public void shouldFindItem(){
        repository.isItemInWarehouse("ABCD1234");
        Mockito.verify(database).isItemInWarehouse("ABCD1234");
    }

    @Test
    public void shouldNotFindItem(){
        repository.isItemInWarehouse("fgdfg");
        Mockito.verify(database).isItemInWarehouse("fgdfg");
    }

    @Test
    public void shouldNotFindItem_2(){
        repository.isItemInWarehouse(null);
        Mockito.verify(database).isItemInWarehouse(null);
    }

}
