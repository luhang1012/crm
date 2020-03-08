package com.shsxt.crm.utils;

import com.shsxt.crm.exceptions.LoginException;
import com.shsxt.crm.exceptions.ParamsException;

/**
 * Created by 15625 on 2020/1/27.
 */
public class AssertUtil {
    public static void isTrue(boolean flag, Integer code, String msg) {
        if (flag) {
            throw new ParamsException(code, msg);
        }
    }
    public static void isTrue(boolean flag, String msg) {
        if (flag) {
            throw new ParamsException(msg);
        }
    }
    public static void isNotLogin(boolean flag, Integer code, String msg) {
        if (flag) {
            throw new LoginException(code, msg);
        }
    }
    public static void isNotLogin(boolean flag, String msg) {
        if (flag) {
            throw new LoginException(msg);
        }
    }
}
