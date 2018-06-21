package cn.bdqn.Sockey;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockets {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(56666);
			System.out.println("***服务器即将启动，等待客户端的连接***");
			Socket socket = serverSocket.accept();
			InputStream is = socket.getInputStream();
			byte [] bytes = new byte[1024];
			int data = 0;
			while((data = is.read(bytes))!=-1){
				String temp = new String(bytes, 0, data);
				System.out.println("我是服务器，读取客户端发过来的信息："+temp);
			}
			socket.shutdownInput();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush();
			pw.close();
			os.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
