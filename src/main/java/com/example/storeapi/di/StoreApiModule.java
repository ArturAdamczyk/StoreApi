package com.example.storeapi.di;

import com.example.storeapi.api.StoreApi;
import com.example.storeapi.api.StoreApiImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class StoreApiModule {

    @Provides
    @Singleton
    StoreApi provideStoreApi(StoreApiImpl storeApi) {
        return storeApi;
    }

}
