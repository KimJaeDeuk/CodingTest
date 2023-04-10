package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2775_부녀회장이될테야 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[k+1][n+1];
			
			for(int i=1; i<=n; i++) {
				arr[0][i] = i;
			}
			
			for(int i=1; i<=k; i++) {
				int sum=0;
				for(int j=0; j<=n; j++) {
					sum += arr[i-1][j];
				}
			}
		}

	}

}