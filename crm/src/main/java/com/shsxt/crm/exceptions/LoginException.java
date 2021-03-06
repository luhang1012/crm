package com.shsxt.crm.exceptions;

/**
 * Created by 15625 on 2020/1/31.
 */
public class LoginException extends RuntimeException{
    private Integer code = 300;
    private String msg = "未登录";

    public LoginException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public LoginException(String msg) {
        super(msg);
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
