package com.example.storeapi;

import com.example.storeapi.api.StoreApi;
import com.example.storeapi.di.DaggerApplicationComponent;

import javax.inject.Inject;

public class Application {
    @Inject
    StoreApi storeApi;

    private Application(){
        DaggerApplicationComponent.builder().build().inject(this);
    }

    public static void main(String[] args) {
        new Application();
    }
}
