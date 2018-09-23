package com.example.storeapi.utils;

import java.util.Map;
import java.util.stream.Stream;

public class HashMapUtils {

    public static <K,V> Stream<Map.Entry<K,V>> mapToStream(Map<K,V> map){
        return map.entrySet().stream();
    }

}
