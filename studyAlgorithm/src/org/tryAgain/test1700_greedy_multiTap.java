package org.tryAgain;
// 백준
// https://www.acmicpc.net/problem/1700

import java.util.*;

public class test1700_greedy_multiTap {

	public static void main(String[] args) {
		int answer=0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] machine = new int[K];
		for(int i=0; i<K; i++) {
			machine[i] = sc.nextInt();
		}

		boolean[] check = new boolean[3];
		List<Integer> tap = new ArrayList<>();
		tap.add(machine[0]);
		for (int i=1; i<machine.length; i++) {
			

			
			boolean is_exist = false;
			// 탭에 이미 꽂혀있는지 확인
			for(int j=0; j<tap.size();j++) {
				if(tap.get(j) == machine[i]) {
					is_exist = true;
					break;
				}
			}
			
			// 이미 꽂혀있으면 끝
			if(is_exist == true)
				continue;
			
			// 이미 꽂혀있는게 아니고, 탭에 빈자리가 있다면 꽂는다
			if(tap.size() < N) {
				tap.add(machine[i]);
				continue;
			}
			
			int maxSubIdx=0 ,maxTapIdx=0;
			// 이미 꽂혀있는게 아니고, 탭에 빈자리가 없다면 
			// 사용중인 기계중 제일 마지막에 재사용 될것을 고른다
			for(int tapIdx=0; tapIdx<N; tapIdx++) {
				// 뒤쪽에서 사용안한다면 순서는 무한대값이다
				int maxIdx = Integer.MAX_VALUE;
				
				for(int subIdx = i+1; subIdx<machine.length; subIdx++) {
					// 뒤쪽에서 사용될 순서값
					if(tap.get(tapIdx) == machine[subIdx]) {
						maxIdx = subIdx;
						break;
					}
					
				}
				// 사용될 순서값이 가장 것을 찾는다
				if(maxSubIdx < maxIdx) {
					maxSubIdx = maxIdx;
					maxTapIdx = tapIdx;
				}
			}
			tap.set(maxTapIdx, machine[i]);
			answer++;
		}
		System.out.println(answer);
	}

}
