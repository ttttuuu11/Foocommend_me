package com.school.foocommend.socket;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


import java.net.Socket;

public class Client {
	Socket socket = null;
	String serverIp = "localhost";
	int serverPort = 9999;
	String storeName;
	List<Map<String, Object>> result;

	public Client(String storeName) {
		this.storeName = storeName;

		try {
			// 서버 연결
			socket = new Socket(serverIp, serverPort); // socket(),connect();
			System.out.println("서버에 연결되었습니다.");
			System.out.println(serverIp + " : " + serverPort);

			RecommendDataSender recommendDataSender = new RecommendDataSender(socket, storeName);
			recommendDataSender.start();
			recommendDataSender.join();
			result = recommendDataSender.getResult();
		} catch (Exception e) {
			e.printStackTrace();
		}// catch
	}
	
	public List<Map<String, Object>> getResult() {
		return result;
	}

}