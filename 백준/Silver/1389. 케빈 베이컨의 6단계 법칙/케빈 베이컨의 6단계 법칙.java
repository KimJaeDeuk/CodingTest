import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int num;
		int cnt;
		Node(int n, int c){
			this.num = n;
			this.cnt = c;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] arr = new boolean[N+1][N+1];
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			arr[left][right] = true;
			arr[right][left] = true;
		}
		
		
		int[] result = new int[N+1];
		for(int i=1; i<=N; i++) {
			
			boolean[][] visited = new boolean[N+1][N+1];
			int vaconNum = 0;
			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(i,0));
			
			while(!queue.isEmpty()) {
				
				Node node = queue.poll();
				int cnt= node.cnt+1;
				for(int k=1; k<=N; k++) {
					
					if((arr[node.num][k] || arr[k][node.num]) && !visited[node.num][k]) {
						queue.add(new Node(k, cnt));
//						System.out.println("vaconNum : "+i+"와 " + k + " 의 합은 : " + cnt);
						visited[node.num][k] = true;
						
						vaconNum += cnt;
					}
					
				}
			}
			result[i] = vaconNum;
			
		}
		
		int min = Integer.MAX_VALUE;
		int num = 0;
		for(int i=N; i>=1; i--) {
			if(result[i] <= min) {
				num = i;
				min = result[i];
			}
		}
		
		System.out.println(num);
		
	}
}