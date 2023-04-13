package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1543_문서검색 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		String target = br.readLine();
		int cnt = 0;
		if(line.length() == target.length() && line.equals(target)) {
			System.out.println(1);
			return;
		} else if(line.length() < target.length()) {
			System.out.println(0);
			return;
		}
		
		for(int i=0; i<line.length() - (target.length()-1) ;) {
			
			if(line.substring(i,i+target.length()).equals(target)) {
				cnt++;
				i+=target.length();
			}else
				i++;
		}
		// aaaaabbbbbb
		// aaaabb
		
		System.out.println(cnt);
	}

}
