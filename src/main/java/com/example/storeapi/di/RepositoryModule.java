package com.example.storeapi.di;

import com.example.storeapi.db.Database;
import com.example.storeapi.db.DatabaseA;
import com.example.storeapi.model.ItemDTO2ItemMapper;
import com.example.storeapi.repository.Repository;
import com.example.storeapi.repository.RepositoryImpl;
import dagger.Module;
import dagger.Provides;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.inject.Singleton;
import java.util.ArrayList;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    Database provideDatabase() {
        return new DatabaseA(new ArrayList());
        //return new DatabaseB(new ConcurrentHashMap<>());
    }

    @Provides
    @Singleton
    ItemDTO2ItemMapper provideRawItem2ItemMapper() {
        return new ItemDTO2ItemMapper();
    }

    @Provides
    @Singleton
    ModelMapper provideModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(provideRawItem2ItemMapper());
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Provides
    @Singleton
    Repository provideRepository(RepositoryImpl repository) {
        return repository;
    }
}
