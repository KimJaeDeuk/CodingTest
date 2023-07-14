package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11332_시간초과 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();		
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String S = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			long L = Integer.parseInt(st.nextToken())*100000000;
			boolean pass = true;
			if(S.equals("O(N)")) {
				if(L < N*T) {
					pass = false;
				}
			}else if(S.equals("O(2^N)")){
				if(L < Math.pow(2, N*T)) pass = false;
			}else if(S.equals("O(N!)")) {
				long a = 1;
				for(long i=1; i<=N*T; i++) {
					if(a*i > L) {
						pass = false;
						break;
					}
					a = a*i;
				}
				
			}else if(S.equals("O(N^2)")) {
				
				
				if(L < Math.pow(N*T, 2)) pass = false;
			}else {
				if(L < Math.pow(N*T, 3)) pass = false;
			}
			if(pass) {
				sb.append("May Pass.").append("\n");
			}else {
				sb.append("TLE!").append("\n");
			}
			
		}
		
		
		

		
		
		System.out.println(sb);

	}

	

}
