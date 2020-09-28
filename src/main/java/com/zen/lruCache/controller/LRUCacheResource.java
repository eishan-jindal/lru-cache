package com.zen.lruCache.controller;

import com.zen.lruCache.dto.ApiResponse;
import com.zen.lruCache.dto.ResponseCodeEnum;
import com.zen.lruCache.service.LRUCacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lru")
public class LRUCacheResource {
    private final LRUCacheService lruCacheService;

    public LRUCacheResource(LRUCacheService lruCacheService) {
        this.lruCacheService = lruCacheService;
    }

    @GetMapping
    public ApiResponse<String> display(){
        try{
            String cache = lruCacheService.display();
            return new ApiResponse<>(true,ResponseCodeEnum.SUCCESS, cache);
        }catch (Exception e){
            return new ApiResponse<>(false, ResponseCodeEnum.INTERNAL_SERVER_ERROR,null, e.getMessage());
        }
    }

    @PostMapping("/initialize")
    public ApiResponse<Object> initialize(@RequestParam(name = "capacity") Integer cacheSize){
        try{
            lruCacheService.initialize(cacheSize);
            return new ApiResponse<>(true, ResponseCodeEnum.SUCCESS);
        }catch (Exception e){
            return new ApiResponse<>(false, ResponseCodeEnum.INTERNAL_SERVER_ERROR,null, e.getMessage());
        }
    }

    @GetMapping("/get")
    public ApiResponse<Integer> get(@RequestParam Integer key){
        try{
            int value = lruCacheService.get(key);
            return new ApiResponse<>(true,ResponseCodeEnum.SUCCESS, value);
        }catch (Exception e){
            return new ApiResponse<>(false, ResponseCodeEnum.INTERNAL_SERVER_ERROR,null, e.getMessage());
        }
    }

    @PostMapping("/put")
    public ApiResponse<Object> put(@RequestParam Integer key, @RequestParam Integer value){
        try{
            lruCacheService.put(key, value);
            return new ApiResponse<>(true,ResponseCodeEnum.SUCCESS, value);
        }catch (Exception e){
            return new ApiResponse<>(false, ResponseCodeEnum.INTERNAL_SERVER_ERROR,null, e.getMessage());
        }
    }

}
