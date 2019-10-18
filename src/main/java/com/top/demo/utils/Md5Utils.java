package com.top.demo.utils;

import com.top.demo.constant.NumberConstant;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lth
 * @date 2019年10月17日 20:44
 */


public class Md5Utils {
    public static String toMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));
        for (int i = 0; i < NumberConstant.THIRTY_TWO - md5code.length(); i++) {
            md5code = md5code.append(0);
        }
        return md5code.toString();
    }
}
