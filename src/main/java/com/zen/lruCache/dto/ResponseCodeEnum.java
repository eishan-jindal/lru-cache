package com.zen.lruCache.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCodeEnum {
    SUCCESS("Success", 200),
    INTERNAL_SERVER_ERROR("Internal server error", 501);

    private final String message;
    private final Integer statusCode;
}
