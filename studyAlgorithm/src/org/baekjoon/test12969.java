package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test12969 {

	static final int NOT_EXIST = -1;
	static boolean[][][][] dp = new boolean[31][31][31][436];
	static char[] S;
	static int N, K;

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		S = new char[N];

		// solve
		if (solve(0, 0, 0, 0)) {

			System.out.println(new String(S));
		} else {

			System.out.println(NOT_EXIST);
		}

	}

	static boolean solve(int x, int a, int b, int p) {
		/*
		 * dp[x][a][b][p]
		 * x자리까지 오기까지의 a,b개수에 따른 쌍의개수p를 기록한다.
		 * x+1자리에 a,b,c 세가지가 들어올때마다 각각 p의개수는 다르다.
		 * a가 오면 p는 변함x
		 * b가 오면 p는 p+a 그동안 있던 모든 a들과 쌍을 이루기 때문에.
		 * c가 오면 p는 p+a+b 그동안 있던 모든 a,b와 쌍을 이루기 때문에. 
		 * 
		 * */
		
		
		// 종료 조건
		if (x == N) {

			if (p == K)
				return true;
			else
				return false;
		}
		
		// 방문했었지만, 다시 방문했다면 해당 문자열이 없는 것이다. return false;
		if (dp[x][a][b][p])
			return false;
		// 방문 여부 체크
		dp[x][a][b][p] = true;
		
		// 한개의  자리에는 A,B,C가 나올수 있으므로 각각 넣어서 확인해본다.
		
		// 1. x번째 원소가 A인 경우
		// AB 다음 A가 오면, 추가될게 없으므로 p그대로.
		S[x] = 'A';
		if (solve(x + 1, a + 1, b, p))
			return true;

		// 2. x번째 원소가 B인 경우
		// AB 다음 B가 오면, 그동안의 쌍(p , 1) + 현재까지 A의 개수(1) => 2가된다
		S[x] = 'B';
		if (solve(x + 1, a, b + 1, p + a))
			return true;

		// 3. x번째 원소가 C인 경우
		// AB 다음 C가 오면, 그동안의 쌍(p , 1) + 현재까지 A의 개수(1), B의개수(1) => 3이된다
		S[x] = 'C';
		if (solve(x + 1, a, b, p + a + b))
			return true;

		return false;
	}

}
