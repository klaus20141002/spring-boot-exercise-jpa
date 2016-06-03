package com.julie.mikaelson.socket.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class EchoClient {
	private SocketChannel socketChannel = null;
	
	public static void main(String[] args) throws IOException {
		new EchoClient().talk();
	}
	
	public EchoClient() throws IOException {
		socketChannel = SocketChannel.open();
		InetAddress ia = InetAddress.getLocalHost();
		
		InetSocketAddress isa = new InetSocketAddress(ia, 8000);
		
		
		
		socketChannel.connect(isa);
		System.out.println("connection success with server");
		
		
		
	}
	
	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut,true);
	}
	
	
	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	
	
	
	public void talk() {
		try {
			BufferedReader br = getReader(socketChannel.socket());
			PrintWriter pw = getWriter(socketChannel.socket());
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
			
			String msg = null;
			
			while((msg = localReader.readLine())!=null) {
				
				
				pw.println(msg);
				System.out.println(br.readLine());
				if(msg.equals("bye")) {
					break;
				}
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socketChannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
