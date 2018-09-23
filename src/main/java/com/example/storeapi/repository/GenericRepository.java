package com.example.storeapi.repository;

public interface GenericRepository <T> {
    boolean add(T o);
    void remove(T o);
}