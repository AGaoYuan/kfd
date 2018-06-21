package cn.bdqn.Sockey02;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LoginServer {

	public static void main(String[] args) throws Exception  {
		ServerSocket serverSocket = new ServerSocket(56666);
		System.out.println("服务器开始监听！");
		Scanner in  = new Scanner(System.in);
		Socket accept = serverSocket.accept();
		while(true){
			InputStream is = accept.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String content = (String)ois.readObject();
			System.out.println(content);
			
			
			OutputStream os = accept.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			String words = in.nextLine();
			words+=accept.getRemoteSocketAddress();
			oos.writeObject(words);
		}
		
		
		
		
		

	}

}
