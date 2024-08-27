package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class No20920_영단어암기는괴로워 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			if(word.length() >= M) {
				if(!map.containsKey(word)) {
					map.put(word, 1);
				} else {
					map.put(word, map.get(word)+1);
				}
			}
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		
		Collections.sort(keySet, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(Integer.compare(map.get(o2), map.get(o1)) == 0 ) {
					if(Integer.compare(o2.length(), o1.length()) == 0) {
						return o1.compareTo(o2);
					}
					return Integer.compare(o2.length(), o1.length());
				}
				
				return Integer.compare(map.get(o2), map.get(o1));
			}
			
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<keySet.size(); i++) {
			sb.append(keySet.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}

}
