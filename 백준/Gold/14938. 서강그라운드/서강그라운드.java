import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", cost=" + cost + "]";
		}
		
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken()); // 수색범위
		int R = Integer.parseInt(st.nextToken());
		
		
		int[] items = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Node>[] graph = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
			
		}
		int max = Integer.MIN_VALUE;
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		for(int i=1; i<=N; i++) {
			int sum = items[i];
			queue.add(new Node(i,0));
			boolean[] visited = new boolean[N+1];
			visited[i] = true;
			while(!queue.isEmpty()) {
				
				Node currNode = queue.poll();
				
				List<Node> nextNodes= graph[currNode.idx];
				
				for(Node nextNode : nextNodes) {
					
					if(currNode.cost + nextNode.cost > M ) {
//						visited[nextNode.idx] = true;
						continue;
					}
					if(!visited[nextNode.idx])
						sum += items[nextNode.idx];
					visited[nextNode.idx] = true;
					queue.add(new Node(nextNode.idx,currNode.cost + nextNode.cost));
					
				}
				
				
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
	
}