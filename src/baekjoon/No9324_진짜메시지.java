package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No9324_진짜메시지 {
	static int N;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String encrypt = br.readLine();
			sb.append(getCheck(encrypt)).append("\n");
		}
		System.out.println(sb);

	}
	
	public static String getCheck(String line) {
		
		StringBuffer sb = new StringBuffer(line);
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i=0; i<sb.length(); i++) {
			char s = sb.charAt(i);
			if(!map.containsKey(s)) {
				map.put(s, 1);
			}else {
				map.put(s, map.get(s)+1);
				if(map.get(s)%4==3) {
					if(i+1>=sb.length() || s != sb.charAt(i+1)) {
						return "FAKE";
					}
				}
			}
			
		}
		
		return "OK";
	}
}