package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;



public class No15686_치킨배달 {
	static int N;
	static int M;	//치킨집 갯수
	static int[][] map;
	static int totalChicken=0;
	static int resultTotalRoad =Integer.MAX_VALUE;
	static boolean visited[][];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int info = Integer.parseInt(st.nextToken());
				map[i][j] = info;
				if(info==2) { 
					totalChicken++;
				}
			}
		}
		
		dfs(0);
		System.out.println(resultTotalRoad);
	}

	private static void dfs(int close) {
		
		if(totalChicken - close== M) {
			int dfsTotalRoad = 0;
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(map[i][j]==1) {
						int dfsHouse = Integer.MAX_VALUE;
						for(int a=1; a<N+1; a++) {
							for(int b=1; b<N+1; b++) {
								if(map[a][b]==2) {
									dfsHouse = Math.min(Math.abs(a-i) + Math.abs(b-j), dfsHouse);
								}
							}
						}
						dfsTotalRoad +=dfsHouse;
					}
				}
			}
			resultTotalRoad = Math.min(resultTotalRoad, dfsTotalRoad);
			
			return;
		}else {
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j]==2) {
						map[i][j] = 0;
						
						dfs(close+1);
						map[i][j] = 2;
					}
				}
			}
			
		}
		
	}
	

}
