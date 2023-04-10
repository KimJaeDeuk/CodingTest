package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No2294_동전2 {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k+1];
		int[] num = new int[n];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.fill(dp, 100001);
		
		dp[0] = 0;
		
		for(int i=0 ; i<n; i++) {
			for(int j=num[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j], dp[j - num[i]] +1);
				for(int s=0; s<=k; s++) {
					System.out.print(dp[s] +" ");
				}System.out.println();
			}
			
		}
		
	}

}
