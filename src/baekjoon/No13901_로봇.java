package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13901_로봇 {
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	
	static int R;
	static int C;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[R][C];
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true; 
		}
		st = new StringTokenizer(br.readLine());
		int nowX = Integer.parseInt(st.nextToken());
		int nowY = Integer.parseInt(st.nextToken());
		arr[nowX][nowY] = true;
		
		st = new StringTokenizer(br.readLine());
		
		int dirArr[] = new int[4];
		for(int i=0; i<4; i++) {
			dirArr[i] = Integer.parseInt(st.nextToken());
		}
		int dir = 0;
		while(canMove(arr, nowX, nowY)) {
			int direction = dirArr[(dir++)%4];
			while(true) {
				int nx = dx[direction] + nowX;
				int ny = dy[direction] + nowY;
				
				if(nx >=0 && ny>=0 && nx<R && ny<C && !arr[nx][ny]) {
					arr[nx][ny] = true;
					nowX = nx;
					nowY = ny;
				} else {
					break;
				}
			}
		}
		System.out.println(nowX + " " + nowY);
	}

	private static boolean canMove(boolean[][] arr, int nowX, int nowY) {
		
		for(int i=1; i<=4; i++) {
			int nx = nowX + dx[i];
			int ny = nowY + dy[i];
			
			if(nx>=0 && ny>=0 && nx<R && ny<C && !arr[nx][ny]) return true;
		}
		
		return false;
	}

}

