package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No2607_SimiliarWord {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String word = br.readLine();
		int cnt=0;
		Map<Character, Integer> word_map = new HashMap<Character,Integer>();
		
		for(int i=0; i<word.length(); i++)
		{
			if(!word_map.containsKey(word.charAt(i))) {
				word_map.put(word.charAt(i), 1);
			}else {
				word_map.put(word.charAt(i), word_map.get(word.charAt(i))+1);
			}
		}
		for(int i=0; i<N-1; i++) {
			String word_c = br.readLine();
			int zero = 0;
			int two = 0;
			int FailCnt = 0;
			if(word_c.length() >= word.length()-1 && word_c.length() <= word.length()+1) {
				
				Map<Character,Integer> word_map2 = new HashMap<Character, Integer>(word_map);
				
				for(int j=0; j<word_c.length(); j++) {
					if(!word_map2.containsKey(word_c.charAt(j))) {
						word_map2.put(word_c.charAt(j), -1);
					}else {
						word_map2.put(word_c.charAt(j),word_map2.get(word_c.charAt(j))-1);
					}
				}
				for(char c : word_map2.keySet()) {
					if(word_map2.get(c)>1 || word_map2.get(c)<-1)
						two++;
					if(word_map2.get(c) == -1 || word_map2.get(c) == 1)
						FailCnt++;
				}
				
				if(two != 0 || FailCnt > 2)
					continue;
				
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
