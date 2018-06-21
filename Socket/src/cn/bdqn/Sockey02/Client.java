package cn.bdqn.Sockey02;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket client = new Socket("192.168.19.100",56666);
		
		while(true){
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			Scanner in = new Scanner(System.in);
			byte [] bytes = new byte [1024];
			String word = in.nextLine();
			word += client.getLocalPort();
			oos.writeObject(word);
			
			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String back = (String)ois.readObject();
			System.out.println(back);
			
		}
		
		
		
		

	}

}
