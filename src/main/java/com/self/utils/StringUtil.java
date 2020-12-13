package com.self.utils;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addZero("123",6));
	}
	
	public static String addZero(String str, int strLength) {
	    int strLen = str.length();
	    StringBuffer sb = null;
	     while (strLen < strLength) {
	          sb = new StringBuffer();
	         sb.append("0").append(str);// 左补0
	       // sb.append(str).append("0");//右补0
	          str = sb.toString();
	          strLen = str.length();
	     }
	    return str.toUpperCase();
	}
}
