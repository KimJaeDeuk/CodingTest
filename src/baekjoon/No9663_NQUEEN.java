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
		
		int cnt = N;
		
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dfs(i,j, 0);
			}
			arr = new int[N][N];
		}
		System.out.println(result);
	}

	private static void dfs(int i, int j, int cnt) {
		
		
		
	}


}
