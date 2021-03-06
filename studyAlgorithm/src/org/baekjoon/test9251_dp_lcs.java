package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test9251_dp_lcs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(getLCS(str1, str2));
    }
 
    public static int getLCS(String str1, String str2) {
 
        int n = str1.length();
        int m = str2.length();
 
        int[][] lcs = new int[n + 1][m + 1];
 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
            
            	// 
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
        return lcs[n][m];
    }

}
