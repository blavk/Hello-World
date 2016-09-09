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
    ServerSocket server; //�䷽��accept ���������ͻ��˵�����  
    Socket socket;  
    BufferedReader in;
    static List<Socket> list = new ArrayList<Socket>();//�������ӵ�Socket����  
    ExecutorService exec;  //�̳߳���(˵���˾��Ǵ���߳��õ�)  
                           //1. Executors.newCachedThreadPool()�����ͳ��ӣ��Ȳ鿴������û����ǰ�������̣߳�����У���reuse.���û�У��ͽ�һ���µ��̼߳������  
                           //2. execute(Runnable r) ��ʵ���Ƕ�Runnable�������start()����  
                           //3. exec.shutdownNow(); һ��ִ�У��߳̽����̳߳���ʧ(�ͻ���)  
    public Server(){  
        try {  
            server = new ServerSocket(10000);//�����������˿�Ϊ22222  
            server.setSoTimeout(7000);
            //exec = Executors.newCachedThreadPool();  
            while(true) {  
            	boolean flg = false;
                socket = server.accept();  
                System.out.println(socket.getInetAddress() + ":��ʼ����");
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
        Socket socket;      //��������Socket����  
        BufferedReader in; //�������������  
        public Tast(Socket socket) throws IOException{  
            this.socket = socket;  
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //��ȡSocket�еĳ���������������ͨ��  
            //ou = new DataOutputStream(socket.getOutputStream());  
        }  
        public void run() {  
            try {  
                  
                //---------- ������Ի����κ����ݰ��Ľ��ܺͷ���  ----------  
                String receive = in.readLine();  //��ȡ�ͻ�����Ϣ  
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
