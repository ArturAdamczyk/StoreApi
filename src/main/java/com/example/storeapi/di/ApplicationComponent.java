package com.example.storeapi.di;

import com.example.storeapi.Application;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
        RepositoryModule.class,
        StoreApiModule.class})
public interface ApplicationComponent {
    void inject(Application application);
}
