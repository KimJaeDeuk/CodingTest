package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No17176_암호해독기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num==0) {
				if(!map.containsKey(' ')) {
					map.put(' ', 1);
				}else {
					map.put(' ', map.get(' ')+1);
				}
			}else if(num>=1 && num<=26) {
				char c = (char)(num-1+'A');
				if(!map.containsKey(c)) {
					map.put(c, 1);
				}else {
					map.put(c, map.get(c)+1);
				}
			}else {
				char c = (char)(num-27+'a');
				if(!map.containsKey(c)) {
					map.put(c, 1);
				}else {
					map.put(c, map.get(c)+1);
				}
			}
		}
		String result = br.readLine();
		
		for(int i=0; i<result.length(); i++) {
			char c = result.charAt(i);
			
			if(map.containsKey(c)) {
				int cnt = map.get(c);
				if(cnt==1) {
					map.remove(c);
				}else {
					map.put(c, map.get(c)-1);
				}
			}else {
				System.out.println("n");
				System.exit(0);
			}
			
			
		}
		System.out.println("y");
	}

}
