package com.julie.mikaelson.socket.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class Handler implements Runnable {
	private SocketChannel socketChannel = null ;
	
	public Handler(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}
	
	@Override
	public void run() {
		handle(socketChannel);
	}

	public void handle(SocketChannel socketChannel){
		Socket socket = socketChannel.socket();
		
		System.out.println("recieved connection from "+ socket.getPort()+" " +socket.getInetAddress());
		
		try {
			BufferedReader br = getReader(socket);
			
			PrintWriter pw = getWriter(socket);
			
			String msg = null ;
			while((msg=br.readLine())!=null) {
				System.out.println(msg);
				
				pw.println(echo(msg));
				
				if(msg.equals("bye")) {
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(socketChannel!=null) {
				try {
					socketChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut,true);
	}
	
	
	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	
	
	public String echo(String msg) {
		return "echo : " + msg ;
	}
	
	
	
	
	
	
}
