package cn.bdqn.Sockey;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;



public class Chiled {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.19.100",56666);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("用户名:admin 密码:123");
			pw.flush();
			socket.shutdownOutput();
			
			InputStream is = socket.getInputStream();
			BufferedReader dr = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = dr.readLine())!=null){
				System.out.println("我是客户端，服务器跟我说："+info);
			}
			dr.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
