package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 함께하는효도 {
	static class Node{
		int idx;
		int x;
		int y;
		int sum;
		int sec;
		
		Node(int idx, int x, int y, int sum, int sec){
			this.idx = idx;
			this.x =x;
			this.y = y;
			this.sum = sum;
			this.sec = sec;
		}
	}
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static boolean visited[][][];
	static int[][] arr;
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		visited = new boolean[M][N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0 ; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			queue.add(new Node(i, x, y, arr[x][y], 0));
			visited[i][x][y] = true;
		}
		
		int[] maxArr = new int[M];
		
		while(!queue.isEmpty()) {
			
			Node n = queue.poll();
			
			if(n.sec > 3) {
				if(n.sum > maxArr[n.idx]) {
					maxArr[n.idx] = n.sum;
				}
				continue;
			} 
			
			for(int k=0; k<4; k++) {
				int nx = dx[k] + n.x;
				int ny = dy[k] + n.y;
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[n.idx][nx][ny]) {
					continue;
				}
				
				int sum = n.sum;
				boolean check = false;
				for(int i=0; i<M; i++) {
					if(visited[i][nx][ny]) {
						check = true;
						break;
					}
				}
				if(!check) {
					
					sum += arr[nx][ny];
				} 
				queue.add(new Node(n.idx, nx,ny, sum, n.sec+1));
				visited[n.idx][nx][ny] = true;
			}
			
		}
		
		
		int sum = 0;
		for(int i =0; i<M;  i++) {
			sum += maxArr[i];
		}
		
		System.out.println(sum);
		
	}

}
