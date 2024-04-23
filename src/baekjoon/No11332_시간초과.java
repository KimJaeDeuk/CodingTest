package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11332_시간초과 {
	static long TIME = 100000000;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();		
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String S = st.nextToken();
			int N = Integer.parseInt(st.nextToken()); // 최대범위
			int T = Integer.parseInt(st.nextToken()); // 테스트케이스
			long L = Integer.parseInt(st.nextToken()) * TIME; // 제한시간
			boolean success = false;
			if(S.equals("O(N)")) {
				if(N * T <= L) {
					success = true;
				}
			} else if(S.equals("O(2^N)")){
				
				if(Math.pow(2, N)*T <= L) {
					success =true;
				}
				
			} else if(S.equals("O(N!)")){
				long fact = 1;
				boolean over = false;
				for(int i=N; i>=2; i--) {
					fact *= i;
					if(fact * T >L) {
						over =true;
						break;
					}
				}
				if(!over)
					success= true;
			} else if(S.equals("O(N^3)")){
				if(Math.pow(N, 3)*T <= L) {
					success =true;
				}
			} else if(S.equals("O(N^2)")){
				if(Math.pow(N, 2)*T <= L) {
					success =true;
				}
			}
			
			
			sb.append(success ? "May Pass." : "TLE!").append("\n");
		}
		
		
		

		
		
		System.out.println(sb);

	}


}
