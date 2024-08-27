package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17484_진우의달여행 {
	static int beforeMove = -1;
	
	static int[][] move = {{-1,1},{0,1},{1,1}};
	
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[][][] dp = new int[N][M][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (i == 0) {
					// 초기식 ①: 첫 행 dp[0][j][k] = map[0][j]
					dp[i][j][0] = arr[i][j];
					dp[i][j][1] = arr[i][j];
					dp[i][j][2] = arr[i][j];
				}
				else if (j == M - 1) {
					// 초기식 ②: 오른쪽 끝 칸 [i][m-1] 으로 못 오는 경우
					dp[i][j][0] = Integer.MAX_VALUE;
				}
				else if (j == 0) {
					// 초기식 ③: 왼쪽 끝 칸 [i][0] 으로 못 오는 경우
					dp[i][j][2] = Integer.MAX_VALUE;
				}
			}
		}
		// 1 좌
		// 2 아래
		// 3 우
		
		for(int i=1; i<N; i++) {
			
			for(int j=0; j<M; j++) {
				
				if(isValid(j+1)) {
					dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + arr[i][j];
				}
				
				if(isValid(j)) {
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
				}
				if(isValid(j-1)) {
					dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + arr[i][j];
				}
			}
			
		}
		
		writeResult(dp);
		
	}

	private static void writeResult(int[][][] dp) {
		int result = Integer.MAX_VALUE;
		for(int j=0; j<M ;j++) {
			for(int k=0; k<3; k++) {
				if(dp[N-1][j][k] == 0) continue;
				result = Math.min(result, dp[N-1][j][k]);
			}
		}
		System.out.println(result);
	}

	private static boolean isValid(int j) {
		if(j >=0 && j<M) return true;
		return false;
	}

}
