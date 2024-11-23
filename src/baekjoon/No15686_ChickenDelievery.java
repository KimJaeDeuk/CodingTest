package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15686_ChickenDelievery {
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M;
	static int[][] map;
	static boolean[] destroyed;
	static ArrayList<Point> home = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]==1) {
					home.add(new Point(i,j));
				} else if(map[i][j]==2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		destroyed = new boolean[chicken.size()];
		
		dfs(0);
	}
	private static void dfs(int num) {
		
		if(num == M) {
			bfs();
		}
	}
	private static void bfs() {
		
	}
	
}