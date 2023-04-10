package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1912_연속합 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = arr[i][0];
		}

		arr[0][1] = arr[0][0];
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N-i; j++) {
				
			}
			
		}
	}

}
