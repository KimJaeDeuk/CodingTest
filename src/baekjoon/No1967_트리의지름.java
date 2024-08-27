package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1967_트리의지름 {
	static class Node{
		int next;
		int cost;
		
		Node(int n, int c){
			this.next = n;
			this.cost = c;
		}

		@Override
		public String toString() {
			return "[next=" + next + ", cost=" + cost + "]";
		}
		
	}
	static ArrayList<ArrayList<Node>> graph;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<N-1; i++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b,c));
		}
		for(int i=0 ;i<=N; i++) {
			System.out.println(graph.get(i).toString());
		}
		int result = 0;
		for(int i=1; i<=N; i++) {
			
			if(graph.get(i).size() == 0) continue;
			dfs(i, 0);
			
			result = Math.max(result, max);
			
		}
		System.out.println(result);
	}
	private static void dfs(int idx, int len) {
		max = Math.max(max, len);
		
		System.out.println("[현재 idx:" + idx+" 현재 max:" + max +"]");
		if(graph.get(idx).size() == 0) return;
		
		for(int i=0; i<graph.get(idx).size(); i++) {
			Node child = graph.get(idx).get(i);
			dfs(child.next, len + child.cost);
			
		}
		
	}

}
