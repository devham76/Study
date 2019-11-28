package org.baekjoon;

import java.util.Scanner;

public class test11048_moving {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n+1][m+1];
		int dp[][] = new int[n+1][m+1];
		
		int[] nx = {1, 0, 1};
		int[] ny = {0, 1, 1};
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.max(dp[i-1][j] , Math.max(dp[i][j-1], dp[i-1][j-1])) + arr[i][j];		
			}
		}	
		System.out.println(dp[n][m]);
	}

}
