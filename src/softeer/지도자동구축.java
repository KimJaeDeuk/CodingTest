package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 지도자동구축 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[16];
		
		dp[0] = 2;
		dp[1] = 3;
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-1]-1;
		}
		System.out.println(dp[N]*dp[N]);
	}

}
