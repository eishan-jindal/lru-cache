package com.zen.lruCache.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties
@Builder
public class ApiResponse<T> {

    private boolean success;
    private Integer code;
    private T data;
    private String message;
    private String detailedMessage;

    /**
     * Basic constructor with no detailed message.
     *
     * @param success success
     * @param code code
     * @param data data
     * @param message message
     */
    public ApiResponse(boolean success, Integer code, T data, String message) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * All args constructor with detailed message.
     *
     * @param success success
     * @param code code
     * @param data data
     * @param message message
     * @param detailedMessage detailedMessage
     */
    public ApiResponse(boolean success, Integer code, T data, String message, String detailedMessage) {
        this(success, code, data, message);
        this.detailedMessage = detailedMessage;
    }

    /**
     * Automatically sets: http status code and
     * message field from LogisticsResponseCodeEnum.
     *
     * Manually set: success.
     *
     * @param success success
     * @param responseCode responseCode
     */
    public ApiResponse(boolean success, ResponseCodeEnum responseCode){
        this(success, responseCode.getStatusCode(), null, responseCode.getMessage());
    }


    /**
     * Automatically sets: http status code and
     * message field from LogisticsResponseCodeEnum.
     *
     * Manually set: success, data.
     *
     * @param success success
     * @param responseCode responseCode
     * @param data data
     */
    public ApiResponse(boolean success, ResponseCodeEnum responseCode, T data){
        this(success, responseCode.getStatusCode(), data, responseCode.getMessage());
    }

    /**
     * Automatically sets: http status code and
     * message field from LogisticsResponseCodeEnum.
     *
     * Manually set: success, data and detailedMessage.
     *
     * @param success success
     * @param responseCode responseCode
     * @param data data
     * @param detailedMessage detailedMessage
     */
    public ApiResponse(boolean success, ResponseCodeEnum responseCode, T data, String detailedMessage){
        this(success, responseCode.getStatusCode(), data, responseCode.getMessage(), detailedMessage);
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", data=" + data +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", detailMessage=" + detailedMessage +
                '}';
    }
}

