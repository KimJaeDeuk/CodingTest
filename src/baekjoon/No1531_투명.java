package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1531_투명 {

	static int arr[][] = new int[101][101];
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int down_x = Integer.parseInt(st.nextToken());
			int down_y = Integer.parseInt(st.nextToken());
			int up_x = Integer.parseInt(st.nextToken());
			int up_y = Integer.parseInt(st.nextToken());
			
			drawMap(down_x, down_y, up_x, up_y);
			
		}
		int cnt = 0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(arr[i][j]>M) cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void drawMap(int down_x, int down_y, int up_x, int up_y) {
		
		for(int i=down_x; i<=up_x; i++) {
			for(int j=down_y; j<=up_y; j++) {
				arr[i][j]++;
			}
		}
		
	}

}
