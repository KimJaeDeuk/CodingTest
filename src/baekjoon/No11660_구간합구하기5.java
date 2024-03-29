package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11660_구간합구하기5 {

	public static void main(String[] args) throws Exception{
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sumArr[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sumArr[i][j] = arr[i][j] + sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1];
			}
		
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int total = sumArr[x2][y2];
			total = total - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}

}
