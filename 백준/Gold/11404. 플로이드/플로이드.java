import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int idx;
		int cost;
		Node(int i, int c) {
			this.idx = i;
			this.cost = c;
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.cost,o2.cost);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int city=1; city<=N; city++) {
			
			queue.add(new Node(city, 0));
			
			int[] dk = new int[N+1];
			Arrays.fill(dk, Integer.MAX_VALUE);
			dk[city] = 0;
//			boolean visited[] = new boolean[N+1];
//			visited[city] = true;
			while(!queue.isEmpty()) {
				Node currNode = queue.poll();
				
				int currIdx = currNode.idx;
				
				ArrayList<Node> nextNodes = graph.get(currIdx);
				
				for(Node nextNode : nextNodes) {
//					if(visited[nextNode.idx]) continue;
					
					if(dk[nextNode.idx] > dk[currNode.idx] + nextNode.cost) {
						dk[nextNode.idx]= dk[currNode.idx] + nextNode.cost;
//						visited[nextNode.idx]= true; 
						queue.add(nextNode);
					}
				}
			}
//			System.out.println("city "+ city+"번쨰");
			for(int i=1; i<N+1; i++) {
				sb.append(dk[i] == Integer.MAX_VALUE ? 0 : dk[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
}