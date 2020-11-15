package com.self.utils;

public class Protocol_721E_Util {
	static String  HEAD =  "7E"; //协议头，固定值
	/**
	 * 
	 * @param tid 机器号 1-255
	 * @param command 指令 2位的16进制字符串
	 * @param data 数据 2n位 的 16进制字符串 , 长度不固定
	 * @return 
	 * 
	 * 计算公式
	 * HEAD 固定值 "7E"
	 * CHKS = CHKS_INIT ^ tid ^ command ^ data
	 * SUMS = SUMS_INIT + tid + command + data + CHKS
	 * Length 是计算出来的
	 * 结果 = HEAD + Length + tidStr + command + DATA + CHKS + SUMS
	 */
	public static String getFullHexStr(int tid ,String command,String data) {
		
		String SSData = "";
		int CHKS  =  255  ;//校验位初始值255--对应十六进制"0xFF"
		int SUMS  =  0;
		String tidStr = tenTo16str(tid); //得到机器号对应的2位数16进制字符串 "02"
		
		SSData = SSData + tidStr + command + data;
		
		//将SSData 每2位16进制，转换成10进制，然后 进行 xor（异或） ,和 SUMS 求值
		for(int i=0;i<SSData.length()/2;i++) {
			String str = SSData.substring(2*i, 2*i+2);
			CHKS = CHKS ^ Integer.parseInt(str, 16);
			SUMS = SUMS + Integer.parseInt(str, 16);
		}
		//再将CHKS转换成16进制字符串拼接到SSData
		SSData = SSData + tenTo16str(CHKS);
		//SUMS 的值还要加上CHKS值
	    SUMS  = SUMS + Integer.parseInt(tenTo16str(CHKS), 16);
	    
	    //SUMS 有一个规则，值大于 'FF'（255） ,需要对'FF'（255）进行求模运算，取余数
	 	//257 Mod 256 ==> 1,再将1转换成16进制字符串 '01'
		
	    SSData = SSData + tenTo16str(SUMS%256);
	    
	    //求出SSData占字节数,一个字节就是2位 。SSData长度除以2.再转换成16进制字符串
		String len = tenTo16str(SSData.length()/2);
		
		return HEAD + len + SSData;
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
		//机器号  "1"
		//指令    "21"
		//DATA   "8401"
		String str = getFullHexStr(1,"21","8401");
		System.out.println(str);
	}

}
