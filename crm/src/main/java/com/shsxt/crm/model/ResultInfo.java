package com.shsxt.crm.model;

/**
 * Created by 15625 on 2020/1/26.
 */
public class ResultInfo {
    private Integer code = 200;
    private String msg = "操作成功";
    private Object obj;

    public ResultInfo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ResultInfo() {
    }

    public ResultInfo(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
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
