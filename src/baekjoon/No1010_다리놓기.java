package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1010_다리놓기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		while(T-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(getDp(N,M)).append("\n");
		}
		System.out.println(sb);
	}

	private static int getDp(int n, int m) {
		
		int nArr[] = new int[n+1];
		int mArr[] = new int[m+1];
		int result = 0;
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=m-(n-i); j++) {
				result++;
			}
		}
		
		
		return result;
	}

}
