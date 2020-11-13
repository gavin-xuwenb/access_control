package com.self.tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import com.self.utils.nettyClient.StringUtil;

public class TCPClient {

	public static String sendMessage(String str) throws IOException {
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		DataOutputStream dos = null; //向服务器写流
		Socket clientSocket =  new Socket("192.168.1.127", 1621);
		String ret = "";
		try {
			//发送数据
			dos = new DataOutputStream(clientSocket.getOutputStream());
			dos.write(StringUtil.toByteArray(str));
			dos.flush();
			
			
			
			//读取数据
			bis = new BufferedInputStream(
					clientSocket.getInputStream());
			dis = new DataInputStream(bis);
			
			byte[] bytes = new byte[1]; // 一次读取一个byte
			boolean con = true;
			while (con && dis.read(bytes) != -1) {
                ret += StringUtil.toHexString(bytes) + " ";
                if (dis.available() == 0) { //一个请求
                	con = false;
                }
            }
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			dos.close();
			dis.close();
			bis.close();
			clientSocket.close();
		}
		return ret;
	}
	
	/**
	 *   获取服务器连接状态
	 * @return 1 : 连接成功   2：连接失败
	 */
	public static Integer getConnection(String serverIp,int port) {
		
		Socket clientSocket = null;
		SocketAddress socketAddress = null;
		try { 
			clientSocket =  new Socket();
			socketAddress = new InetSocketAddress(serverIp, port);
			clientSocket.connect(socketAddress, 2000);
			System.out.println(clientSocket);
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		TCPClient  client = new TCPClient();
		//String str = client.sendMessage("7E06012184015A01");
		//System.out.println(str);
		int flag = client.getConnection("192.168.1.127",1621);
		System.out.println(flag);
	}
}
