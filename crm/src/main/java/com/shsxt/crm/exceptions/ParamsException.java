package com.shsxt.crm.exceptions;

/**
 * Created by 15625 on 2020/1/27.
 */
public class ParamsException extends RuntimeException {
    private Integer code = 300;
    private String msg = "参数异常";

    public ParamsException() {
    }

    public ParamsException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
    public ParamsException(String msg) {
        super("参数异常");
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
