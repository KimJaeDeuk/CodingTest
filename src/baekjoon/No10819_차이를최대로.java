package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10819_차이를최대로 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int[] selected;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		arr= new int[N];
		visited = new boolean[N];
		selected = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
				
		dfs(0);
		System.out.println(result);
	}
	private static void dfs(int depth) {
		
		if(depth==N) {
			
			int getResult= getResult();
			
			result = Math.max(result, getResult);
			return;
		}
		
		for(int i=0;i<N; i++) {
			
			if(!visited[i]) {
				visited[i] = true;
				selected[depth] = arr[i];
				dfs(depth+1);
				visited[i] = false;
			}
			
		}
		
	}
	private static int getResult() {
		
		int sum = 0;
		
		for(int i=0; i<N-1; i++) {
			sum+=Math.abs(selected[i] - selected[i+1]);
		}
		return sum;
	}

}
