package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No10844_쉬운계단수 {

	static final long MOD = 1000000000;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[][] = new long[101][10];
		
		for(int i=1; i<10; i++)
			dp[1][i] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<10;j++) {
				if(j==0) {
					dp[i][0] = dp[i-1][1]%MOD;
				}else if(j==9) {
					dp[i][9] = dp[i-1][8]%MOD;
				}else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%MOD; 
				}
				
			}
		}
		long result = 0;
		for(int i=0; i<=9; i++) {
			
			result+=dp[N][i];
		}
		System.out.println(result%MOD);
				
	
	}

}
