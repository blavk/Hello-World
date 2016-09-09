package com.testgit;

import java.io.BufferedReader;
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.io.InputStreamReader;
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
  
public class Server {  
    ServerSocket server; //其方法accept 用来监听客户端的链接  
    Socket socket;  
    BufferedReader in;
    static List<Socket> list = new ArrayList<Socket>();//保存链接的Socket对象  
    ExecutorService exec;  //线程池类(说白了就是存放线程用的)  
                           //1. Executors.newCachedThreadPool()缓存型池子，先查看池中有没有以前建立的线程，如果有，就reuse.如果没有，就建一个新的线程加入池中  
                           //2. execute(Runnable r) 其实就是对Runnable对象调用start()方法  
                           //3. exec.shutdownNow(); 一旦执行，线程将从线程池消失(客户端)  
    public Server(){  
        try {  
            server = new ServerSocket(10000);//启动监听，端口为22222  
            server.setSoTimeout(7000);
            //exec = Executors.newCachedThreadPool();  
            while(true) {  
            	boolean flg = false;
                socket = server.accept();  
                System.out.println(socket.getInetAddress() + ":开始连接");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String receive = in.readLine();
                System.out.println(receive);
                in.close();  
                socket.close();
                if(receive != null && receive.contains("zhou")){
                	break;
                }
                //list.add(socket);  
                //exec.execute(new Tast(socket));   
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }    
    }  
    class Tast implements Runnable {  
        Socket socket;      //服务器端Socket对象  
        BufferedReader in; //数据输入输出流  
        public Tast(Socket socket) throws IOException{  
            this.socket = socket;  
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //获取Socket中的出入输出流，以完成通信  
            //ou = new DataOutputStream(socket.getOutputStream());  
        }  
        public void run() {  
            try {  
                  
                //---------- 这里可以换成任何数据包的接受和发送  ----------  
                String receive = in.readLine();  //读取客户端信息  
                System.out.println(receive);
                  
                //ou.close();  
                in.close();  
                socket.close();  
                  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
    public static void main(String[] args) {  
        new Server();  
    }  
}  
