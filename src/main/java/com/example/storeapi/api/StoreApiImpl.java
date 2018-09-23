package com.example.storeapi.api;

import com.example.storeapi.model.Item;
import com.example.storeapi.model.ItemDTO;
import com.example.storeapi.repository.Repository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;

@Log4j2
public class StoreApiImpl implements StoreApi {
    private Repository repository;
    private ModelMapper modelMapper;

    @Inject
    public StoreApiImpl(Repository repository, ModelMapper modelMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addItem(String serialNumber, String itemType, String warrantyExpirationDate){
        try{
            repository.add(
                    modelMapper.map(new ItemDTO(serialNumber, itemType, warrantyExpirationDate), Item.class));
        }catch(MappingException e){
            log.error(e);
        }
    }

    @Override
    public void removeItem(String serialNumber){
        repository.remove(serialNumber);
    }

    @Override
    public boolean isItemInWarehouse(String serialNumber){
        return repository.isItemInWarehouse(serialNumber);
    }

    @Override
    public int countAllItems(){
       return repository.countAllItems();
    }

    @Override
    public int countByItemType(String itemType){
        return repository.countByItemType(itemType);
    }

    @Override
    public List<String> findExpiredWarrantyItemsSerialNumbers(){
        return repository.findExpiredWarrantyItemsSerialNumbers();
    }
}
