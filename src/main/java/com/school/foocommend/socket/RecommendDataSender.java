package com.school.foocommend.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RecommendDataSender extends Thread {
	private Socket socket;
	private FileInputStream fis;
	private BufferedOutputStream bos;

	private String storeName;

	private OutputStream os;

	private InputStream is;
	private BufferedInputStream bis;


	private List<Map<String, Object>> result;

	public RecommendDataSender(Socket socket, String storeName) {
		this.socket = socket;
		this.storeName = storeName;
		try {
			// 데이터 스트림 생성
			this.os = socket.getOutputStream();
			bos = new BufferedOutputStream(os);
			this.is = socket.getInputStream();
			bis = new BufferedInputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendData() throws IOException {
//		byte[] data = new byte[(int) (fileSize)];

		//System.out.println("send image ... ");
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.print(storeName);
			out.flush();
//			bos.write(filename.toString().getBytes());
//			bos.flush();
			System.out.println("데이터 전송 중");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	public List<Map<String, Object>> receiveData() throws IOException {
		List<Map<String, Object>> recommendDataList = new ArrayList<Map<String, Object>>();
		
		try {

			BufferedReader stdIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			

			String in = stdIn.readLine();

			String [] inSplit = in.split("\\s");
			System.out.println(inSplit[0]+","+inSplit[inSplit.length-1]);
			
			Map<String, Object> recommendDataMap = new HashMap<String, Object>();
			
			recommendDataMap.put("store_number", inSplit[0].toString());
			recommendDataMap.put("store_name", inSplit[inSplit.length-1].toString());
			
			recommendDataList.add(recommendDataMap);

			in = stdIn.readLine();
			int cnt = 1;
			// EOF는 null문자를 포함하고 있다.
			while (in != null) {
				cnt++;
				// 읽은 문자열을 출력한다.
				inSplit = in.split("\\s");
				Map<String, Object> recommendDataMapSub = new HashMap<String, Object>();
				System.out.println(inSplit[0]+","+inSplit[inSplit.length-1]);
				recommendDataMapSub.put("store_number", inSplit[0].toString());
				recommendDataMapSub.put("store_name", inSplit[inSplit.length-1].toString());				
				recommendDataList.add(recommendDataMapSub);

				// 다음 문자열을 가르켜준다.
				in = stdIn.readLine();
				if(cnt>=10) {
					System.out.println("끝");
					
					return recommendDataList;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return recommendDataList;
	}

	public List<Map<String, Object>> getResult() {
		return result;
	}

	public void close() {
		try {
			bos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			sendData();
			result = receiveData();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("종료");
			close();
		} 
	}

}