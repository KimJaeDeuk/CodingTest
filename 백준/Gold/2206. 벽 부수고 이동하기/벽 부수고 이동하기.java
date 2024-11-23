

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Move{
	int x;
	int y;
	int dist;
	boolean destroy;
	Move(int x, int y, int dist, boolean destroy){
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.destroy = destroy;
	}
}

public class Main {

	static Queue<Move> queue = new LinkedList<Move>();
	static int arr[][];
	static boolean visited[][][];
	
	static int[] nx = {0,0,-1,1};
	static int[] ny = {1,-1,0,0};
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M][2];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				arr[i][j] = line.charAt(j)-'0';
				
			}
		}
		
		bfs();
		
	}
	
	private static void bfs() {
		
		queue.add(new Move(0,0,1,false));
		visited[0][0][0] = true;
		int qDist = 0;
		int result = 0;
		while(!queue.isEmpty()) {
			
			Move m = queue.poll();
			int qx = m.x;
			int qy = m.y;
			if(qx == N-1 && qy == M-1) {
				
				result = m.dist;
				break;
			}
			qDist = m.dist;
			
			
			
			for(int k=0; k<4; k++) {
				int dx = qx+nx[k];
				int dy = qy+ny[k];
				
				if(dx < 0 || dy < 0 || dx>=N || dy>=M) {
					continue;
				}
				int dist = qDist+1;
				if(arr[dx][dy]==0) {
					
					if(!m.destroy && !visited[dx][dy][0]) {
						visited[dx][dy][0] = true;
						queue.add(new Move(dx,dy,dist,false));
					}else if(m.destroy && !visited[dx][dy][1]) {
						visited[dx][dy][1] = true;
						queue.add(new Move(dx,dy,dist,true));
					}
					
				}else {
					
					if(!m.destroy && !visited[dx][dy][1]) {
						visited[dx][dy][1] = true;
						queue.add(new Move(dx,dy,dist,true));
					}
					
				}
			}
			
			
		}
		
		if(result == 0 )
			result = -1;
		System.out.println(result);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
