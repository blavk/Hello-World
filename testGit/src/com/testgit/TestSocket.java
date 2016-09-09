package com.testgit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
	 class MySocket implements Runnable{


		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				ServerSocket s1 = new ServerSocket(10000);
				s1.setSoTimeout(15000);
				Socket s2 = s1.accept();
				
				BufferedReader bf = new BufferedReader(new InputStreamReader(s2
						.getInputStream()));
				String rcv = "";
				//int read ;
				while(true){
					if((rcv = bf.readLine()) != null){
						System.out.println(rcv);
						break;
//						if(!rcv.matches(".*ccms.990.001.01.*")){
//							break;
//						}
					}
//					if((read = bf.read()) != -1){
//						char c = (char) read;
//						rcv += c;
//						if (c == '}'){
//							System.out.print("ok: "+ rcv + rcv.matches(".*ccms.990.001.01.*"));
//							if(!rcv.matches(".*ccms.990.001.01.*")){
//								System.out.println("here");
//							    break;
//						    }
//							rcv = "";
//						}
//						
//					}
				}
				s2.close();
				Socket s3 = s1.accept();
				BufferedReader bf2 = new BufferedReader(new InputStreamReader(s3
						.getInputStream()));
				while(true){
					if((rcv = bf2.readLine()) != null){
						System.out.println(rcv);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySocket ms = new TestSocket().new MySocket();
		Thread t = new Thread(ms);
		t.start();
		


	}

}
