package com.self.utils;

import java.io.IOException;

import com.self.tcp.TCPClient;

public class CommonThread {
	public static void senCMD(String cmdStr,String ip,int port) {
		new Thread() {
			@Override
			public void run() {
				 System.out.println("向"+ip+":"+port+"发送指令："+cmdStr);
				 String str="";
				 try {
					str = TCPClient.sendMessage(cmdStr,ip,port);
				 } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
				 System.out.println("返回消息："+str);
			}
		}.start();
	}
}