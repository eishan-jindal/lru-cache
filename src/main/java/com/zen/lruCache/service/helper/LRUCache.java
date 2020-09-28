package com.zen.lruCache.service.helper;

public class LRUCache {
    private Cache<Integer, Integer> cache;

    public LRUCache(int capacity){
        this.cache = new Cache<>(capacity, true);
    }

    public int get(int key) {
        if(cache.get(key) == null)
            return -1;
        else
            return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
