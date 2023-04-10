package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No14889_스타트와링크 {
	
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n];
		dfs(0,0);
		System.out.println(min);
	}
	
	//idx를 통해서 불필요한 순회 예외
	private static void dfs(int idx, int depth) {
		
		if(depth==n/2) {
			diff();
			return;
		}
		
		for(int i=idx; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
		
	}
	private static void diff() {
		int start = 0;
		int link = 0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				
				if(visited[i] && visited[j] ) {
					start += arr[i][j];
					start += arr[j][i];
				}else if(!visited[i] && !visited[j]) {
					link += arr[i][j];
					link += arr[j][i];
				}
				
			}
		}

		int diff = Math.abs(start-link);
		if(diff==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		min = Math.min(diff, min);
		
	}

}
