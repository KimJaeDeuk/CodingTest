package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11725_트리의부모찾기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		StringBuilder sb = new StringBuilder();
		int[] result = new int[N+1];
		
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[N+1];
		
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int parent = queue.poll();
			
			for(int i=0; i<graph[parent].size(); i++) {
				int child = graph[parent].get(i);
				
				if(!visited[child]) {
					result[child] = parent;
					queue.add(child);
					visited[child] = true;
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
}
