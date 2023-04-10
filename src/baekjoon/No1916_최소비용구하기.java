package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1916_최소비용구하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int arr[][] = new int[N+1][N+1];
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[start][end] = cost;
			
			
			
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		int idx = start;

		for(int i=start; i<=end; i++) {
			
			
		}
	}
}
