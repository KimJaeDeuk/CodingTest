package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2303_NumberGame {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[][] arr = new int[N+1][6];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			int max = Integer.MIN_VALUE;
			for(int j=0; j<3; j++) {
				for(int k=j+1; k<4; k++) {
					for(int l=k+1; l<5; l++) {
						max = Math.max(max, (arr[i][j] + arr[i][k] + arr[i][l])%10);
					}
				}
			}
			arr[i][5] = max;
		}
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int i=1; i<=N; i++) {
			if(max < arr[i][5]) {
				max = arr[i][5];
				idx = i;
			}
			if(max==arr[i][5]) {
				idx = i;
			}
			
		}
		System.out.println(idx);
		
	}

}
