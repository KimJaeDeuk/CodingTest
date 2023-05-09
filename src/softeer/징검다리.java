package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 징검다리 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N];
		for(int i=0; i<N; i++)
			dp[i] = 1;
		
		
		for(int i=0; i<N; i++) {	
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
			
		}
		int result = 0;
		for(int i=0; i<N; i++)
			result = Math.max(result, dp[i]);
		
		System.out.println(result);
	}

}
