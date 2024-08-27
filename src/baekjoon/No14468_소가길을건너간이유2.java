package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class No14468_소가길을건너간이유2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int cnt = 0;
		
		for(int i=0; i<26; i++) {
			char c = (char) ('A'+(char)i);
			
			int first = line.indexOf(c);
			int last = line.lastIndexOf(c);
			
		}
		
		System.out.println(cnt);

	}

}