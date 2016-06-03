package com.julie.mikaelson.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
	
	public static void main(String[] args) throws IOException {
		new EchoServer().service();
	}
	
	
	private int port = 8000;
	
	private ServerSocketChannel serverSocketChannel = null;
	
	private ExecutorService executorService ;
	
	private static final int POOL_MULTIPLY = 4 ;
	
	
	public EchoServer() throws IOException {
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_MULTIPLY);
		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().setReuseAddress(true);
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		
		System.out.println("server set up");
		
	}
	
	public void service() {
		while(true) {
			
			SocketChannel socketChannel = null ;
			try {
				socketChannel = serverSocketChannel.accept() ;
				executorService.execute(new Handler(socketChannel));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
}
