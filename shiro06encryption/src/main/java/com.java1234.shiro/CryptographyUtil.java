package com.java1234.shiro;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {

    /**
     * base64算法加密，可逆
     *
     * @param str
     * @return
     */
    public static String encodeBase64(String str) {

        return Base64.encodeToString(str.getBytes());
    }

    /**
     * base64算法解密，可逆
     *
     * @param str
     * @return
     */
    public static String decodeBase64(String str) {

        return Base64.decodeToString(str);
    }

    /**
     * Md5算法加密，不可逆，撒盐，穷举都不能破解
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
        System.out.println("Base64算法加密：" + CryptographyUtil.encodeBase64(password));
        System.out.println("Base64算法解密：" + CryptographyUtil.decodeBase64(CryptographyUtil.encodeBase64(password)));
        System.out.println("Md5撒盐加密：" + CryptographyUtil.md5(password, "java1234"));
    }
}
