import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static int white = 0, blue = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringBuilder sb  =new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		dfs(N, 0, 0);
		
		System.out.println(white + "\n" + blue);
		
	}
	private static void dfs(int size, int x, int y) {
		
		if(check(size, x, y)) {
			if(arr[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		dfs(size/2, x, y);
		dfs(size/2, x+size/2, y);
		dfs(size/2, x, y+size/2);
		dfs(size/2, x+size/2, y+size/2);
		
	}
	private static boolean check(int size, int x, int y) {
		int num = arr[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(num != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
		
}
