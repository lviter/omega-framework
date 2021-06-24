package com.omega.framework.common.util.number;

/**
 * @Author lviter
 * @Description 
 * @Date 17:26 2021/6/24
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class RandomStringUtils {
    /**
     * 默认字符源
     */
    public static String DEFAULT_SOURCE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * 字母字符源
     */
    public static String ALPHABETIC_SOURCE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 数字字符源
     */
    public static String NUMERIC_SOURCE = "0123456789";

    /**
     * 创建一个指定长度和字符源的随机字符串
     *
     * @param count
     * @param chars
     * @return
     */
    public static String random(int count, String chars) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, chars);
    }

    /**
     * 创建一个指定长度的随机默认类型字符串
     *
     * @param count
     * @return
     */
    public static String random(int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, DEFAULT_SOURCE);
    }

    /**
     * 创建一个指定长度的随机字母字符串
     *
     * @param count
     * @return
     */
    public static String randomAlphabetic(int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, ALPHABETIC_SOURCE);
    }

    /**
     * 创建一个指定长度的随机数字字符串
     *
     * @param count
     * @return
     */
    public static String randomNumeric(int count) {
        return org.apache.commons.lang3.RandomStringUtils.random(count, NUMERIC_SOURCE);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(random(1, "AB"));
        }
        System.out.println(random(10));
        System.out.println(randomNumeric(10));
        System.out.println(randomAlphabetic(10));
    }
}
