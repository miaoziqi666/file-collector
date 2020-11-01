package com.souhu.filecollector.common;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>请求结果</p>
 */
@Data
public final class RespData<T> implements Serializable {

    private static final long serialVersionUID = -8303810106110857438L;

    public static final int SUCCESS = 200;
    public static final int ERROR = 500;


    private int code;

    private String message;

    private T data;

    public boolean hasSuccessed() {
        return this.code == SUCCESS;
    }

    public static <T> RespData ok() {
        RespData respData = new RespData();
        respData.setCode(SUCCESS);
        return respData;
    }

    public static <T> RespData<T> ok(T data) {
        RespData<T> respData = new RespData<>();
        respData.setCode(SUCCESS);
        respData.setData(data);
        return respData;
    }

    public static <T> RespData ok(int code) {
        RespData respData = new RespData();
        respData.setCode(code);
        return respData;
    }


    public static RespData fail(String message) {
        RespData respData = new RespData();
        respData.setCode(ERROR);
        respData.setMessage(message);
        return respData;
    }


    public static RespData fail(int code, String message) {
        RespData respData = new RespData();
        respData.setCode(code);
        respData.setMessage(message);
        return respData;
    }


}
