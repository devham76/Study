package org.baekjoon;

import java.util.Scanner;

public class test2163_dp_chocolate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println( (n-1) + (n * (m-1)) );
	}

}
