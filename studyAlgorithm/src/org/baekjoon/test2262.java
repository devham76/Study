package org.baekjoon;

import java.io.*;
import java.util.*;

/*
 * 나의 문제 : 컴퓨팅적인 사고부족
순위가 큰 팀이 올라오면 차이가 많이 난다. 따라서 순위가 큰 팀 부터 제거해준다.
1. 맨왼쪽에 제일 순위가 큰 팀이있다면 바로 오른쪽과 대결
2. 맨오른쪽이라면 바로 왼쪽과 대결
3. 그게 아니라면 제일 큰 순위 양쪽 팀중 큰 순위인 팀과 대결
 * */
public class test2262 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine());
		List<Integer> list = new ArrayList<>();
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			list.add( Integer.parseInt(st.nextToken()));
		
		int sum = 0;
		while(list.size() > 1) {
			
			int max = 1;
			int maxIdx = -1;
			// 가장 큰 수를 찾아 없앤다
			for(int i=0; i<list.size(); i++) {
				if(max < list.get(i)) {
					max = list.get(i);
					maxIdx = i;
				}
			}
			// 맨 왼쪽에 있다면 오른쪽과 대결
			if(maxIdx == 0) {
				sum += list.get(0) - list.get(1);
			}
			// 맨 오른쪽에 있다면 왼쪽과 대결
			else if (maxIdx == list.size()-1) {
				sum += list.get(list.size()-1) - list.get(list.size()-2);
			}
			// 자신의 양옆중 큰 것과 대결
			else {
				int idx = list.get(maxIdx-1) > list.get(maxIdx+1) ? maxIdx-1 : maxIdx+1;			
				sum += list.get(maxIdx) - list.get(idx);
			}
			list.remove(maxIdx);
		
		}
		System.out.println(sum);
		
	}

}
