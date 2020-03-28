package org.baekjoon;

import java.util.Scanner;

public class test15989 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[][] dp = new int[10001][4];

		// num을 만들수있는 수열의 오름차순 제인 끝 숫자는 1,2,3중하나이다
		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[1][3] = 0;

		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[2][3] = 0;

		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		for (int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}

		while (T-- > 0) {
			int n = sc.nextInt();
			
			System.out.println(dp[n][1]+dp[n][2]+dp[n][3]);
		}
	}

}
