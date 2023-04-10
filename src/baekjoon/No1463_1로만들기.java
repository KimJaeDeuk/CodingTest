package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1463_1로만들기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[3000001];
		
		Arrays.fill(dp, 1000001);
		dp[1] = 0;
		
		for(int i=1; i<N+1; i++) {
			
			dp[i+1] = Math.min(dp[i+1], dp[i] +1);
			dp[i*2] = Math.min(dp[i*2], dp[i] +1);
			dp[i*3] = Math.min(dp[i*3], dp[i] +1);
			
			
			
		}
		System.out.println(dp[N]);
	}

}
