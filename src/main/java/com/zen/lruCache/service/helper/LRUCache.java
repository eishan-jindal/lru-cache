package com.zen.lruCache.service.helper;

import java.util.Iterator;
import java.util.Map;

public class LRUCache {
    private final static String SEPARATOR = " => ";
    private final static String SPACE = "  ";
    private final static String OPEN = "{";
    private final static String CLOSE = "}";

    private Cache<Integer, Integer> cache;
    private Integer miss = 0;

    public LRUCache(int capacity){
        this.cache = new Cache<>(capacity, true);
        this.miss = 0;
    }

    public int get(int key) {
        if(cache.get(key) == null) {
            miss++;
            return -1;
        }
        else
            return cache.get(key);
    }

    public void put(int key, int value) {
        if(!cache.containsKey(key))
            miss++;
        cache.put(key, value);
    }

    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("Total miss: ").append(miss).append(" ");
        Iterator<Map.Entry<Integer, Integer>> cacheIterator = cache.entrySet().iterator();
        while (cacheIterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = cacheIterator.next();
            sb.append(OPEN).append(entry.getKey()).append(SEPARATOR).append(entry.getValue()).append(CLOSE).append(SPACE);
        }
        return sb.toString();
    }
}
