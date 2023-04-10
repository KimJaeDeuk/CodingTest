package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2193_이친수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[91];
		
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i=3; i<=90; i++) {
			
			dp[i] = dp[i-1] + dp[i-2];
			
		}
		System.out.println(dp[N]);

	}

}

// 1
// 10
// 100 101
// 1000 1001 1010
// 10000 10001 10010 10100 10101
// 2 1 2 2 1 8