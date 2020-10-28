package com.self.utils;

public class Protocol_721E_Util {
	static int   xor_init = 0xFF; //XOR 初始值
	static int   head =     0x7E;
	static int   len =      0x06;
	static int   tid =      0x01; //1
	static int   command =  0x21; //33
	static int   data1 =    0x84; //132
	static int   data2 =    0x01; //1

	public static void main(String[] args) {

		
		int xor  = xor_init ^ tid ^ command ^ data1 ^ data2; //90
		System.out.println("xor="+Integer.toHexString(xor).toUpperCase()); //0x5A
		System.out.println("xor="+xor); //90
		
		int sum = tid + command + data1 + data2 + xor; //257
		
		System.out.println("sum="+sum); //257
		
		//大于一个字节 (0xFF) ，取低位1个字节
		System.out.println("sum="+Integer.toHexString(sum).toUpperCase()); //0x0101
	}

}
