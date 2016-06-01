package com.julie.mikaelson.fun;

public class CreateRandom {
	
	/**
	 * 
	 */
	public static int getRandom(int N, int M) {
		
		return (int)(M+Math.random()*(N-M));		
	}
	
	public static void main(String[] args) {
		for(int i = 0 ; i<100;i++) {
			System.out.println(getRandom(10,1));
		}
	}

}
