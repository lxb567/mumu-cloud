package com.xb;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    private static final int SUCCESS = 200;

    public static <T> R<T> ok(T data) {
        return new R<T>(SUCCESS,null,data);
    }


    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
