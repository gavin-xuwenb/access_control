package com.self.utils;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

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
	
	/**
	 * 硬件返回的16进制字符串  转换成时间格式
	 * @param longTimeStr
	 * @return
	 */
	public static String timeForat(String longTimeStr) {
		
		if(StringUtils.isBlank(longTimeStr)) {
			return "GET FAILD";
		} else {
			//硬件返回的 每个字节中间有个空格
			longTimeStr = longTimeStr.replaceAll(" ", "");
			
			if(longTimeStr.length()<24) {
				return "GET FAILD";
			}else {
			    //硬件返回的年份是不精确的 year % 100  的余数，1901  和 2001  ，2101 返回值会一样
				//相隔100年以上才会出现误差，所有基本可以忽略
				//查询时间的时候，前缀默认为当前年份，这样进一步减小误差的可能
				Calendar sysdate = Calendar.getInstance();
		        String year_prefix = String.valueOf(sysdate.get(Calendar.YEAR)).substring(0, 2);
				
				String year = year_prefix + refill2(Integer.parseInt(longTimeStr.substring(22, 24), 16));
				String month = refill2(Integer.parseInt(longTimeStr.substring(20, 22), 16));
				String date = refill2(Integer.parseInt(longTimeStr.substring(18, 20), 16));
				String hour = refill2(Integer.parseInt(longTimeStr.substring(14, 16), 16));
				String minute = refill2(Integer.parseInt(longTimeStr.substring(12, 14), 16));
				String second = refill2(Integer.parseInt(longTimeStr.substring(10, 12), 16));
	
				return year+"/"+month+"/"+date+" "+hour+":"+minute+":"+second;
			}
		}
	}
	
	/**
	 * 将当前系统时间 装换16进制格式字符串
	 * 
	 * Second + Minute + Hour + dayOfWeek + dayOfMonth + Month + (Year % 100)
	 * @return
	 */
    public static String getTimeDATA() {
    	Calendar sysdate = Calendar.getInstance();
    	String year = tenTo16str(sysdate.get(Calendar.YEAR)%100);
    	String month = tenTo16str(sysdate.get(Calendar.MONTH)+1);
    	String dayOfMonth = tenTo16str(sysdate.get(Calendar.DAY_OF_MONTH));
    	String dayOfWeek = tenTo16str(sysdate.get(Calendar.DAY_OF_WEEK)); //1-7 周日-周六
    	String hour = tenTo16str(sysdate.get(Calendar.HOUR_OF_DAY)); //24小时制
    	String minute = tenTo16str(sysdate.get(Calendar.MINUTE));
    	String second = tenTo16str(sysdate.get(Calendar.SECOND));
    	
		return second+minute+hour+dayOfWeek+dayOfMonth+month+year;
	}
	
	/**
	 * 补齐2位数---左补0
	 * @param longTimeStr
	 * @return
	 */
	public static String refill2(int str) {
		return str >= 10?(""+str):("0" +str);
	}
	
	public static void main(String[] args) {
		//远程开门  机器号  "1" 指令    "21"   DATA   "8401"
		//String str = getFullHexStr(1,"21","8401");
		
		
		//获取机器时间  机器号  "1" 指令    "24"   DATA  ""
		//7E 24 00 03 01 04       06      0D    01              0F    0B      14         43 01 02 00 C5 ...
		//               second   minute  Hour  day of week     date  month   year%100
		//               04       06      13    1-7 周日-周六     15    11      20-->2020
		
		System.out.println(getFullHexStr(1,"24",""));
		System.out.println(timeForat("7E2400030104060D010F0B14"));
		System.out.println(getTimeDATA());
		System.out.println(getFullHexStr(1,"23","00010203040520"));
	}

}
