package com.nagisazz.booteasy.base.result;

import com.nagisazz.booteasy.base.exception.InfoCode;
import com.nagisazz.booteasy.util.PropertiesLoader;

/**
 * @author NagisaZZ
 * @description: Result
 * @date 2019/4/22  12:07
 */
public class Result {

    private static final String SUCCESS_MSG = "操作成功";

    private static final String FAIL_MSG = "操作失败";

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(boolean success, String desc, Object data) {
        this.success = success;
        this.desc = desc;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    private boolean success = false;
    private String desc;
    private Object data;

    public String getDesc() {
        return this.desc;
    }

    public Object getData() {
        return this.data;
    }

    public static Result success() {
        return new Result(true, SUCCESS_MSG, "");
    }

    public static Result success(Object data) {
        return new Result(true, SUCCESS_MSG, data);
    }

    public static Result success(Object data, InfoCode infoCode) {
        return new Result(true, PropertiesLoader.getProperty(infoCode.name()), data);
    }

    public static Result fail() {
        return new Result(false, FAIL_MSG, "");
    }

    public static Result fail(InfoCode infoCode) {
        return new Result(false, PropertiesLoader.getProperty(infoCode.name()), "");
    }

    public static Result fail(Exception e) {
        return new Result(false, e.getMessage(), "");
    }

    public Result() {
    }
}
