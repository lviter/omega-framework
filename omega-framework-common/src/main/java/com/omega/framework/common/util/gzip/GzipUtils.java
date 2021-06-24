package com.omega.framework.common.util.gzip;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Author lviter
 * @Description 压缩字符工具类
 * @Date 17:34 2021/6/24
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class GzipUtils {
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";

    /**
     * 字符串压缩为GZIP字节数组
     *
     * @param str
     * @return
     */
    public static byte[] compress(String str) {
        return compress(str, GZIP_ENCODE_UTF_8);
    }

    /**
     * 字符串压缩为GZIP字节数组
     *
     * @param str
     * @param encoding
     * @return
     */
    public static byte[] compress(String str, String encoding) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes(encoding));
            gzip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    /**
     * GZIP解压缩
     *
     * @param bytes
     * @return
     */
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    /**
     * 解压并返回String
     *
     * @param bytes
     * @return
     */
    public static String uncompressToString(byte[] bytes) {
        return uncompressToString(bytes, GZIP_ENCODE_UTF_8);
    }

    /**
     * 解压
     *
     * @param bytes
     * @param encoding
     * @return
     */
    public static String uncompressToString(byte[] bytes, String encoding) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        byte[] bytes = {31, -117, 8, 0, 0, 0, 0, 0, 0, 0, -85, 86, 74, 45, 75, -51, 43, 9, 72, 44, 74, -52, -11, 78, -83, 84, -78, 82, 42, 78, 77, -50, -49, 75, -119, 79, -50, 72, -52, -53, 75, -51, 81, -46, 81, -54, 44, 46, 115, -55, -52, 77, -51, 43, -50, -52, -49, 43, 6, 43, 116, 9, -15, 15, 86, -78, -118, -82, 86, 42, -64, -48, 86, 81, -102, -105, 9, -44, 3, -106, 8, 75, -52, 41, 77, 69, -107, 50, 4, -54, -27, 37, -26, -126, 68, 95, -52, -100, -11, -84, 123, -2, -45, -115, -13, -98, 53, 44, 87, -86, -115, -83, 5, 0, 46, 103, 71, 52, -118, 0, 0, 0};
        System.out.println(uncompressToString(bytes));
    }
}
