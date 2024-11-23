import java.io.BufferedReader;
import java.io.InputStreamReader

public class Main {
	
	static int N;
	
	static char[][] arr;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		dfs(N, 0, 0);
		System.out.println(sb.toString());
	}


	private static void dfs(int len, int x, int y) {
		
		if(check(len, x, y)) {
//			if(len == N) {
				sb.append(arr[x][y]);
//			} 
			return;
		}
		if(len != 1) {
			sb.append("(");
			dfs(len/2, x, y);
			
			dfs(len/2, x, y+len/2);
			
			dfs(len/2, x+len/2, y);
			
			dfs(len/2, x+len/2, y+len/2);
			sb.append(")");
		}
	}


	private static boolean check(int len, int x, int y) {
	
		char check = arr[x][y];
		for(int i=x; i<x+len; i++) {
			for(int j=y; j<y+len; j++) {
				if(x==i && y== j) continue;
				
				if(check != arr[i][j]) return false;
			}
		}
		
		return true;
	}
}
