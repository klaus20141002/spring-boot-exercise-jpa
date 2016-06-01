package com.julie.mikaelson.fun;

public class We {
	
	/**
	 * 我喜欢的人是舒婷
	 */
	public static void sayLove() {
//		for(int i = 0 ; i<1001 ; i++) {
//			System.out.println("Julie , I Love You !!");
//		}
		
		
		for(int i = 0 ;i<=11;i++) {
			for(int j = 11;j>i;j--) {
				for(int e = 0;e<j;e++) {
					System.out.print(" ");
				}
				System.out.print("Love*Love");
				for(int e = 0;e<i;e++) {
					System.out.print(" ");
				}
				System.out.println("Love*Love");
			}
		}
	}

	
	public static void main(String[] args) {
		sayLove();
	}
}
