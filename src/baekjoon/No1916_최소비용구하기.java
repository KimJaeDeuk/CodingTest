package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	int cost;
	
	public Node(int e, int c) {
		this.end = e;
		this.cost = c;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost < o.cost ? -1 : 1;
	}
}

public class No1916_최소비용구하기 {
	
	static int N;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int minCost[];
	static int start;
	static int end;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		minCost = new int[N+1];
		for(int i=1; i<=N; i++) minCost[i] = Integer.MAX_VALUE;
		for(int i=0; i<N+1; i++)
			graph.add(new ArrayList<Node>());
		
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<M; i++) {
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e,cost));
			st = new StringTokenizer(br.readLine()," ");
		}
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(minCost[end]);
	}
	private static void bfs() {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start,0));
		minCost[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
//			for(int i=1; i<N+1; i++) {
//				System.out.print("[ D["+i+"] : " + minCost[i]+ " ] ");
//			}
//			System.out.println();
			if(minCost[curNode.end] < curNode.cost) continue;
			
			for(int i=0; i<graph.get(curNode.end).size(); i++) {
				Node next = graph.get(curNode.end).get(i);
				
				if(next.cost + curNode.cost < minCost[next.end]) {
					minCost[next.end] = next.cost+curNode.cost;
					queue.add(new Node(next.end, minCost[next.end]));
				}
			}
		}
	}
}
