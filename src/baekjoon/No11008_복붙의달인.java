package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11008_복붙의달인 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-->0) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String p = st.nextToken();
			
			int pLength = p.length();
			for(int i=0; i<s.length(); i++) {
				if(i+pLength-1<s.length() && p.equals(s.substring(i,i+pLength))) {
					cnt++;
					i += pLength-1;
				}else {
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
