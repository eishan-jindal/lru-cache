package com.zen.lruCache.service.helper;

import java.util.LinkedHashMap;
import java.util.Map;

public class  Cache<K, V> extends LinkedHashMap<K, V> {

    private final static int DEFAULT_SIZE = 16;
    private final static float DEFAULT_LOAD_FACTOR = .75F;

    private int cacheSize = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    public Cache(int capacity, boolean accessOrder){
        super(DEFAULT_SIZE, DEFAULT_LOAD_FACTOR, accessOrder);
        this.cacheSize = capacity;
    }
}
