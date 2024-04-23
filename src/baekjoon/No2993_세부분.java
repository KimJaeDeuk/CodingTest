package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2993_세부분 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		String result = "";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n.length(); i++) {
			sb.append("z");
		}
		result = sb.toString();
		int  cnt = 0;
		for(int i=0; i<n.length()-2; i++) {
			StringBuilder f = new StringBuilder();
			f.append(n.substring(0, i+1)).reverse();
			for(int j=i+1; j < n.length()-1; j++) {
				StringBuilder s = new StringBuilder();
				s.append(n.substring(i+1, j+1)).reverse();
				for(int k = j+1; k<n.length(); k++) {
					StringBuilder t = new StringBuilder();
					t.append(n.substring(j+1, n.length())).reverse();
					String min = f.toString()+s.toString()+t.toString();
					if(result.compareTo(min) > 0 ) {
						result = min;
					}
				}
			}
		}
		System.out.println(result);
	}

}
