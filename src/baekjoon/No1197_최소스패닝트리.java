package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1197_최소스패닝트리 {
	
	static class Node{
		int next;
		long cost;
		Node(int n, long c) {
			this.next = n;
			this.cost = c;
		}
	}
	
	
	static int V, E;
	static List<Node> graph[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,c));
		}
		
		int visitCnt = 0;
		boolean visited[];
		PriorityQueue<Node> queue = new PriorityQueue<>( (o1,o2) -> Long.compare(o1.cost, o2.cost));
		
		for(int i=1; i<=V; i++) {
			
			visited = new boolean[V+1];
			
			queue.add(new Node(i, 0));
			visitCnt++;
			while(!queue.isEmpty()) {
				
			}
			
			
			if(visitCnt==V) {
				
			}
		}
		
	}

}
