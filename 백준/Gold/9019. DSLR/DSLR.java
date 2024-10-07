import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int num;
		StringBuilder sb;
		
		Node(int n, StringBuilder sb2){
			this.num = n;
			sb = sb2;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder result = new StringBuilder();
		while(T-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Set<Integer> visited = new HashSet<>();
			Queue<Node> queue = new LinkedList<>();
			visited.add(A);
			
			queue.add(new Node(A, new StringBuilder()));
			while(!queue.isEmpty()) {
				
				Node node = queue.poll();
				int num = node.num;
				StringBuilder nodeBuilder = node.sb;
				if(num == B) {
					result.append(nodeBuilder.toString()).append("\n");
					break;
				}
				
				int D = (num*2)%10000;
				check(D, visited, queue ,"D", nodeBuilder);
				
				int S  = num-1;
				if(S < 0) {
					S = 9999;
				}
				check(S, visited, queue ,"S", nodeBuilder);
				int L = num;
				if(L / 1000 == 0) {
					L *= 10;
				} else {
					int div = L/1000;
					L = (L - (div * 1000))*10 + div;   
				}
				
				//String numString = String.format("%04d", num);
				
				check(L, visited, queue, "L", nodeBuilder);
				
				int R = num;
				if(R%10 == 0) {
					R /= 10;
				} else {
					int mod = R%10;
					R = (R / 10) + mod*1000; 
				}
				
				//int R = Integer.parseInt(numString.substring(3,4) +numString.substring(0,3));
				
				check(R, visited, queue, "R", nodeBuilder);
			}
			
			
		}
		System.out.println(result);
	}

	private static void check(int num, Set<Integer> visited, Queue<Node> queue, String type, StringBuilder sb) {
		
		if(!visited.contains(num)) {
			visited.add(num);
			StringBuilder newBuilder = new StringBuilder(sb);

			newBuilder.append(type);
			Node nodeD = new Node(num, newBuilder);
			queue.add(nodeD);
		}
		
	}
}
