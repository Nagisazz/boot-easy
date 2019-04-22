package com.nagisazz.booteasy.util;


import org.apache.commons.codec.binary.Base64;

/**
 * @author NagisaZZ
 * @description: Base64Util
 * @date 2019/4/22  11:57
 */
public class Base64Util {

    /**
     * 加密
     *
     * @param string
     * @return
     */
    public static String string2Base(String string) {
        return new String(Base64.encodeBase64(string.getBytes()));
    }

    /**
     * 解密
     *
     * @param base
     * @return
     */
    public static String base2String(String base) {
        return new String(Base64.decodeBase64(base));
    }
}
