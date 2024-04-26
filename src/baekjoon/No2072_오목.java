package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2072_오목 {
	private static int arr[][] = new int[20][20];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = i%2==0 ? 2 : 1;
			if(i < 10) continue;
			
			isSuccess(x, y, 'w', i+1);
			isSuccess(x, y, 'h', i+1);
			isDiagonal(x, y, i+1);
		}
		
		System.out.println(-1);
	}
	private static void isDiagonal(int x, int y, int turnTime) {
		int cnt = 0;
		int max = 0;
		for(int i=x-4, j = y-4; i<x+5 ; i++, j++) {
			if(i>=0 && i<20 && j >=0 && j<20) {
				if(arr[i][j] == arr[x][y]) {
					cnt += 1;
					max = Math.max(cnt, max);
				}  else {
					cnt = 0;
				}
			}
		}
		if(max == 5) {
			battle(turnTime);
		}
		cnt = 0;
		max = 0;
		
		for(int i=x+4, j= y-4; j<y+5; i--, j++) {
			if(i>=0 && i<20 && j >=0 && j<20) {
				if(arr[i][j] == arr[x][y]) {
					cnt += 1;
					max = Math.max(cnt, max);
				}  else {
					cnt = 0;
				}
			}
		}
		if(max == 5) {
			battle(turnTime);
		}
	}
	private static void isSuccess(int x, int y, char type, int turnTime) {
		int cnt = 0;
		int max = 0;
		for(int i = x-4; i<x+5; i++) {
			if(i >=0 && i < 20) {
				if(arr[i][y] == arr[x][y]) {
					cnt += 1;
					max = Math.max(cnt, max);
				}  else {
					cnt = 0;
				}
			}
		}
		if(max == 5) {
			battle(turnTime);
		}
		cnt = 0;
		max = 0;
		for(int i = y-4; i<y+5; i++) {
			if(i >=0 && i < 20) {
				if(arr[x][i] == arr[x][y]) {
					cnt += 1;
					max = Math.max(cnt, max);
				}  else {
					cnt = 0;
				}
			}
		}
		
		if(max == 5) {
			battle(turnTime);
		}
	}
	private static void battle(int i) {
		System.out.println(i);
		System.exit(0);
	}

}
