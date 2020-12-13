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
    
    //十进制数值 转换成 2位的16进制字符串 
  	public static String tenTo16str(int digital) {
  		/**
  		 * 为啥要加256？  256为16的平方
  		 * 这里是个小的技巧，比如十进制数2, 对应的16进制就是'2'，但是我这边16进制要取两位,变成 '02' 怎么办？
  		 * 256对应16进制第3高位的1，'1xx'
  		 * 2+256对应的16进制就是 '102'，然后 substring(1),舍掉高位的1（256）  就得到 '02'
  		 */
  		return Integer.toHexString(digital+256).substring(1).toUpperCase();
  	}
    
    
    public static void main(String[] args) {
    	System.out.println(int2Hex(62000));
//    	System.out.println(hex2int("029c"));
//    	
//    	System.out.println(int2Hex(1234));
//    	System.out.println(hex2int("022b"));
    }
}
