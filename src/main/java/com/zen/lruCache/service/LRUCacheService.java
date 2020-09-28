package com.zen.lruCache.service;

import com.zen.lruCache.service.helper.LRUCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LRUCacheService {

    private LRUCache lruCache = null;
    private boolean isInitialized = false;

    public void initialize(Integer cacheSize) {
        lruCache = new LRUCache(cacheSize);
        isInitialized = true;
        log.info("Initialized cache with max page capacity: {}",cacheSize);
    }

    public int get(int key) throws Exception {
        if(!isInitialized)
            throw new Exception("Cache has not been initialized");

        return lruCache.get(key);
    }

    public void put(int key, int value) throws Exception {
        if(!isInitialized)
            throw new Exception("Cache has not been initialized");

        lruCache.put(key, value);
    }
}
