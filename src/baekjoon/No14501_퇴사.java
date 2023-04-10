package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14501_퇴사 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int N = Integer.parseInt(br.readLine());
		int[] t = new int[N];
		int[] p = new int[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		int dp[][] = new int[N][2];
		dp[0][0] = t[0];
		dp[0][1] = p[0]; 
		for(int i=1; i<N; i++) {
			
			
			
			
		}
		
	}

}
