import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	
	static int N, K;
	static class Node{
		int num;
		int cnt;
		Node(int n, int c) {
			this.num = n;
			this.cnt = c;
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(min);
	}
	private static void bfs() {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(N,0));
		boolean visited[] = new boolean[100001];
		visited[N] = true;
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			if(node.num == K) {
				min = Math.min(min, node.cnt);
				
			}
			int doubleNum = node.num*2;
			if(doubleNum >=0 && doubleNum <=100000 && !visited[doubleNum]) {
				visited[doubleNum] = true;
				queue.add(new Node(doubleNum, node.cnt));
			}
			int minus = node.num-1;
			int plus = node.num+1;
			if(minus >= 0 && !visited[minus]) {
				visited[minus] = true;
				queue.add(new Node(minus, node.cnt+1));
			}
			
			if(plus <=100000 && !visited[plus]) {
				visited[plus] = true;
				queue.add(new Node(plus, node.cnt+1));
			}
		}
 		
	}

}