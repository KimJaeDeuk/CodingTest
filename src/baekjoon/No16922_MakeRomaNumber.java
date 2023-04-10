package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No16922_MakeRomaNumber {
	static int[] num = {1,5,10,50};
	static boolean[] visited;
	static int ans=0;
	static int N;
	static int sum[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[10001];
		sum = new int[10001];
		dfs(0,0,0);
		
		System.out.println(ans);
	}

	private static void dfs(int depth, int idx, int sum) {
		
		if(depth==N) {
			if(!visited[sum]) {
				visited[sum] = true;
				ans++;
			}
			return;	
		}
		
		for(int i=idx; i<4; i++) {
			dfs(depth+1 , i , num[i] + sum);
		}
		
	}

}
