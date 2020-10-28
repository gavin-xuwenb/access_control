package com.self.utils;

public class HexUtil {
    
    /**
     * 字节流转成十六进制表示
     */
    public static String encode(byte[] src) {
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < src.length; n++) {
            strHex = Integer.toHexString(src[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
        }
        return sb.toString().trim();
    }
    
    /**
     * 十六进制字符串转成字节流
     */
    public static byte[] decode(String src) {
        int m = 0, n = 0;
        int byteLen = src.length() / 2; // 每两个字符描述一个字节
        byte[] ret = new byte[byteLen];
        for (int i = 0; i < byteLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            int intVal = Integer.decode("0x" + src.substring(i * 2, m) + src.substring(m, n));
            ret[i] = Byte.valueOf((byte)intVal);
        }
        return ret;
    }
    
    /**
     * 十进制数值转换成16进制字符串
     * 123 ==> '7b'
     * @param value
     * @return
     */
    public static String int2Hex(int value) {
    	return Integer.toHexString(value);
    }
    
    /**
     * 16进制字符串 转换成 十进制数值
     * '7b' ==> 123
     * @param value
     * @return
     */
    public static int hex2int(String value) {
    	return Integer.decode("0x"+value);
    }
}
