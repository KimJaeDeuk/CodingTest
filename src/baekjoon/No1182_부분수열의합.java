package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1182_부분수열의합 {
	static int N;
	static int S;
	static int[] arr;
	static boolean[] visited;
	static int cnt=0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
			
		dfs(0, 0);
		
		System.out.println(S==0 ? cnt-1 : cnt);
	}
	private static void dfs(int depth, int sum) {
		if(N==depth) {
			if(sum==S)
				cnt++;
			
			return;
		}
		
		dfs(depth+1, sum);
		dfs(depth+1, sum+arr[depth]);
		
		
	}
	

}
