package com.example.storeapi;

import com.example.storeapi.di.ApplicationComponent;
import com.example.storeapi.di.RepositoryModule;
import com.example.storeapi.di.StoreApiModule;
import com.example.storeapi.DaggerBaseIntegrationTest_TestComponent;
import dagger.Component;
import org.junit.Before;

import javax.inject.Singleton;

public class BaseIntegrationTest {
    protected TestComponent component;

    @Singleton
    @Component(modules = {
            RepositoryModule.class,
            StoreApiModule.class})
    interface TestComponent extends ApplicationComponent {
        void inject(StoreApiIntegrationTest apiTest);
    }

    @Before
    public void setUp()  {
        component = DaggerBaseIntegrationTest_TestComponent.builder().build();
    }
}
