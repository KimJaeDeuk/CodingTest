package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No10974_모든순열 {
	static int N;
	static StringBuffer sb = new StringBuffer();
	static int[] out;
	static boolean[] visited;
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		out = new int[N];
		visited = new boolean[N];
		dfs(0, 0);
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++)
			sb.append(list.get(i)).append("\n");
		System.out.println(sb.toString());
		
	}
	private static void dfs(int depth, int start) {
		
		if(depth == N) {
			for(int i=0; i<N; i++) {
				sb.append(out[i]+" ");
			}
			
			list.add(sb.toString());
			sb = new StringBuffer();
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[i] = depth+1;
				dfs(depth+1, i+1);
				visited[i] = false;
			}
		}
	}

}
