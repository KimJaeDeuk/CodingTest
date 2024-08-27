package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No9663_NQUEEN {
static int arr[][];
static int result = 0;
static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dfs(i,j, 0);
			}
			arr = new int[N][N];
		}
		System.out.println(result);
	}

	private static void dfs(int x, int y, int cnt) {
		
		
		
		if(cnt == N) {
			result++;
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==0 && canPlace(i,j)) {
					arr[x][y] = 1;
					dfs(i,j,cnt+1);
					arr[x][y] = 0;
				}
			}
		}
		
	}

	private static boolean canPlace(int x, int y) {
		
		return (left(x, y) &&right(x,y)
				&& up(x,y)
		&& down(x,y)
		&& leftUp(x,y)
		&& leftDown(x,y)
		&&rightUp(x,y)
		 &&rightDown(x,y) );
		
	}

	private static boolean rightDown(int x, int y) {
		for(int i=x; i<N; i++) {
			for(int j=y; j<N; j++) {
				if(arr[i][j]==1) return false;
			}
		}
		return true;
	}

	private static boolean rightUp(int x, int y) {
		for(int i=x; i<N; i++) {
			for(int j=y; j>=0; j--) {
				if(arr[i][j]==1) return false;
			}
		}
		return true;
	}

	private static boolean leftDown(int x, int y) {
		for(int i=x; i>=0; i--) {
			for(int j=y; j<N; j++) {
				if(arr[i][j]==1) return false;
			}
		}
		return true;
	}

	private static boolean leftUp(int x, int y) {
		for(int i=x; i>=0; i--) {
			for(int j=y; j>=0; j--) {
				if(arr[i][j]==1) return false;
			}
		}
		return true;
	}

	private static boolean down(int x, int y) {
		for(int i=x; i<N; i++) {
			if(arr[i][y] == 1) return false;
		}
		return true;
	}

	private static boolean up(int x, int y) {
		for(int i=x; i>=0; i--) {
			if(arr[i][y] == 1) return false;
		}
		return true;
	}

	private static boolean right(int x, int y) {
		for(int i=y; i<N; i++) {
			if(arr[x][i] == 1) return false;
		}
		return true;
	}

	private static boolean left(int x, int y) {
		for(int i=y; i>=0; i--) {
			if(arr[x][i] == 1) return false;
		}
		return true;
	}


}
