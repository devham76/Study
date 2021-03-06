package org.line;

import java.util.*;

/*
 * datasource : 문서, 태그1태그2...
 * tags에 있는 태그를 가지고 있는 문서 나열.
 * */

public class Test2004_5 {

	public static void main(String[] args) {
		String[][] d = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" }, { "doc3", "t1", "t6", "t7" },
				{ "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] t = { "t1", "t2", "t3", "t" };
		solution(d, t);
	}

	static List<doc> list = new ArrayList<>();
	static HashSet<String> tagsh = new HashSet<>();

	public static String[] solution(String[][] dataSource, String[] tags) {
		HashMap<String, Integer> hm = new HashMap<>();

		// -- 1. doc마다 tag개수 세어주기

		// -- 개선
		// tags를 hashset에 넣어주고, doc의 태그드를 확인 
		// 내가 구현한 find : O(n)
		// 개선한다면,O(1)
		for (String tag : tags) {
			tagsh.add(tag);
		}
		// ----

		int docTaglen = dataSource[0].length;
		for (int i = 0; i < dataSource.length; i++) {
			String docName = dataSource[i][0];
			for (int t = 0; t < tags.length; t++) {
				String tag = tags[t];

				// 태그이름이 있다면 cnt+1
				for (int j = 1; j < docTaglen; j++) {
					if (tag.equals(dataSource[i][j])) {
						int idx = find(docName);
						if (find(docName) == -1) {
							list.add(new doc(docName, 1));
						} else {
							int cnt = list.get(idx).cnt;
							list.get(idx).addCnt();
						}
					}

				}
			}
		}

		Comparator<doc> Comp = new Comparator<doc>() {
			public int compare(doc a, doc b) {
				if (a.cnt == b.cnt)
					return a.name.compareTo(b.name);
				else
					return b.cnt - a.cnt;
			}
		};
		list.sort(Comp);

		int maxLen = list.size() > 10 ? 10 : list.size();
		String[] answer = new String[maxLen];
		for (int i = 0; i < maxLen; i++) {
			answer[i] = list.get(i).name;
			System.out.println(list.get(i).name + " " + list.get(i).cnt);
		}
		return answer;
	}

	private static int find(String docName) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals(docName)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean find2(String docName) {
		if (tagsh.contains(docName))
			return true;
		return false;
	}
}

class doc {
	String name;
	int cnt;

	doc(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}

	void addCnt() {
		this.cnt++;
	}
}