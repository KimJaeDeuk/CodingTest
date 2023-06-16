package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class No14468_소가길을건너간이유2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int cnt = 0;
			
		int pos1[] = new int[26];
		int pos2[] = new int[26];
		for(int i = 0; i < 52; i++) {
			int idx = line.charAt(i)-'A';
			if(pos1[idx] == 0) pos1[idx] = i+1;
			else pos2[idx] = i+1;
		}
		
		for(int i=0; i<26; i++) {
			for(int j=0; j<26; j++) {
				
				if(pos1[i] < pos1[j] && pos1[j] < pos2[i] && pos2[i] < pos2[j]) cnt++;
				 
			}
		}
		
		System.out.println(cnt);

	}

}
