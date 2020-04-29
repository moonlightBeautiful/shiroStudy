package com.ims.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {

    /**
     * base64加密
     *
     * @param str
     * @return
     */
    public static String encBase64(String str) {
        return Base64.encodeToString(str.getBytes());
    }

    /**
     * base64解密
     *
     * @param str
     * @return
     */
    public static String decBase64(String str) {
        return Base64.decodeToString(str);
    }

    /**
     * Md5加密
     *
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }

    public static void main(String[] args) {

        String password = "123456";

        //base64算法加密，可逆
        System.out.println("Base64加密：" + Base64.encodeToString(password.getBytes()));
        //base64算法解密，可逆
        System.out.println("Base64解密：" + Base64.decodeToString("MTIzNDU2"));

        //Md5算法加密，不可逆，撒盐，穷举都不能破解
        System.out.println("Md5撒盐解密：" + new Md5Hash(password, "xxx").toString());

    }
}
