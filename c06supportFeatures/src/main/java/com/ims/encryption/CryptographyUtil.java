package com.ims.encryption;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {



    public static void main(String[] args) {

        String password = "123456";

        //base64算法加密，可逆
        System.out.println(Base64.encodeToString(password.getBytes()));
        //base64算法解密，可逆
        System.out.println(Base64.decodeToString("MTIzNDU2"));

        //Md5算法加密，不可逆，撒盐，穷举都不能破解
        System.out.println(new Md5Hash(password, "xxx").toString());

    }
}
