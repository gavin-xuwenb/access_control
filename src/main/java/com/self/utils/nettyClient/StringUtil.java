package com.self.utils.nettyClient;

public class StringUtil {
	/**
	    * 16进制的字符串表示转成字节数组
	    *
	    * @param hexString
	    * 16进制格式的字符串
	    * @return 转换后的字节数组
	    **/
	    public static byte[] toByteArray(String hexString) {
	        hexString = hexString.toLowerCase();
	        final byte[] byteArray = new byte[hexString.length() / 2];
	        int k = 0;
	        for (int i = 0; i < byteArray.length; i++) {// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
	            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
	            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
	            byteArray[i] = (byte) (high << 4 | low);
	            k += 2;
	        }
	        return byteArray;
	    }
	    
	    /**
	    * 字节数组转成16进制表示格式的字符串
	    *
	    * @param byteArray
	    * 需要转换的字节数组
	    * @return 16进制表示格式的字符串
	    **/
	     public static String toHexString(byte[] byteArray) {
	        String str = null;
	        if (byteArray != null && byteArray.length > 0) {
	            StringBuffer stringBuffer = new StringBuffer(byteArray.length);
	            for (byte byteChar : byteArray) {
	                stringBuffer.append(String.format("%02X", byteChar));
	            }
	            str = stringBuffer.toString();
	        }
	        return str;
	     }
}
