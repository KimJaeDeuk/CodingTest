

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class San{
	int x;
	int y;
	int dec;
	San(int x, int y, int dec){
		this.x = x;
		this.y = y;
		this.dec = dec;
	}
}

public class Main {
	static Queue<San> que = new LinkedList<San>();
	static Queue<San> dec = new LinkedList<San>();
	static boolean[][] visited;
	static int arr[][];
	static int[] nx = {0,0,-1,1};
	static int[] ny = {1,-1,0,0};
	static int N;
	static int M;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		
		while(true) {
			int cnt=0;
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]!=0 && !visited[i][j]) {
						cnt++;
						bfs(i,j);
					}
				}
			}
					
			if(cnt==0) {
				System.out.println(0);
				return;
			}else if(cnt>=2) {
				System.out.println(year);
				return;
			}
			year++;
			
			while(!dec.isEmpty()) {
				San s = dec.poll();
				arr[s.x][s.y] = arr[s.x][s.y]- s.dec < 0 ? 0 : arr[s.x][s.y]-s.dec;   
			}

			
		}

	}
	private static void bfs(int i, int j) {
		
		que.add(new San(i,j,0));
		visited[i][j] = true;
		
		while(!que.isEmpty()) {
			San s= que.poll();
			int qx = s.x;
			int qy = s.y;
			int qdec = 0;
			for(int k=0; k<4; k++) {
				int dx = qx + nx[k];
				int dy = qy + ny[k];
				
				if(dx<0 || dy< 0 || dx>=N || dy>=M) continue;
				
				if(!visited[dx][dy] && arr[dx][dy] != 0) {
					que.add(new San(dx,dy,0));
					visited[dx][dy] = true;
				}
				if(arr[dx][dy] == 0) {
					qdec++;
				}
			}
		
			dec.add(new San(qx,qy,qdec));
		}
		
		
	}

}
