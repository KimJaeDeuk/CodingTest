import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int x;
		int y;
		Node(int x, int y) {
			this.x =x;
			this.y=y;
		}
	}
	static int N, M;
	static int[][] arr;
	static boolean visited[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		
		while(check()) {
			
			visited = new boolean[N][M];
			bfs(0,0);
			melt();

			time++;
		}
		System.out.println(time);
	}

	private static void bfs(int numX, int numY) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(numX, numY));
		visited[numX][numY] = true;
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			for(int k=0; k<4; k++) {
				int nx = dx[k] + node.x;
				int ny = dy[k] + node.y;
				
				if(nx < 0 || ny < 0 || nx >=N || ny>=M || visited[nx][ny]) continue;
				
				if(arr[nx][ny]==0) {
					queue.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}
				
				if(arr[nx][ny]>=1) {
					arr[nx][ny]++; 
				}
			}
			
		}
		
	}

	private static void melt() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] > 2) arr[i][j] = 0;
				else if(arr[i][j] == 2) arr[i][j] = 1; 
			}
		}
	}

	private static boolean check() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) return true;
			}
		}
		return false;
	}
	
}