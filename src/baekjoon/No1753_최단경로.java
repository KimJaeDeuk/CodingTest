package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1753_최단경로 {
	
	static class MinPath {
		int idx;
		int cost;
		
		MinPath(int i, int c) {
			this.idx = i;
			this.cost = c;
		}

		@Override
		public String toString() {
			return "[idx=" + idx + ", cost=" + cost + "]";
		}
		
	}
	private static ArrayList<ArrayList<MinPath>> graph;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		graph = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int dist[] = new int[V+1];
		for(int i=0; i<V+1; i++) {
			graph.add(new ArrayList<MinPath>());
			dist[i] = Integer.MAX_VALUE;
		}
		
		int startIdx = Integer.parseInt(br.readLine());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new MinPath(v, w));
		}
		
		
		for(int i=1; i<V+1; i++) {
			
		}
		dist[startIdx] = 0;
		
		boolean visited[] = new boolean[V+1];
		
		PriorityQueue<MinPath> queue = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
		
		queue.add(new MinPath(startIdx, 0));
		
		while(!queue.isEmpty()) {
			
			MinPath node = queue.poll();
			visited[node.idx] = true; 
			if(dist[node.idx] < node.cost) {
				continue;
			} 
			ArrayList<MinPath> nextNodes = graph.get(node.idx);
			
			for(int i=0; i<nextNodes.size(); i++) {
				MinPath nextNode = nextNodes.get(i);
				if(!visited[nextNode.idx] &&dist[nextNode.idx] > nextNode.cost + dist[node.idx]) {
					dist[nextNode.idx] = nextNode.cost + dist[node.idx];
					queue.add(new MinPath(nextNode.idx, dist[nextNode.idx]));
				}
				
			}
			
		}
		
		for(int i=1; i<V+1; i++) {
			sb.append(dist[i]==Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

}
