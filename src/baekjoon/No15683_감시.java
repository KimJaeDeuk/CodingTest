package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class CCTV{
	int type;
	
	int direction = 0;
	int x;
	int y;
	CCTV(int type, int direction, int x, int y){
		this.type = type;
		this.direction = direction;
		this.x = x;
		this.y = y;
	}
}
class Detect{
	int x;
	int y;
	Detect(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class No15683_감시 {
	static int N;
	static int M;
	static boolean visited[][];
	
	static int nx[] = {0,1,0,-1};
	static int ny[] = {1,0,-1,0};
	static int [][] map;
	static ArrayList<CCTV> cctvList = new ArrayList<CCTV>();
	static int min;
	static Queue<Detect> q = new LinkedList<Detect>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = N*M;
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num!=0 && num!=6) {
					cctvList.add(new CCTV(num, 0, i, j));
				}
			}
		}
		
		int result = getResult();
		min = Math.min(result, min);
		dfs(0, 0);
		System.out.println(min);
	}
	private static void dfs(int depth, int start) {
		if(depth == cctvList.size()) {
			int result = getResult();
			min = Math.min(result, min);
			if(min == 0) {
				System.out.println(min);
				System.exit(0);
			}
			return;
		}
		for(int i=start; i<cctvList.size(); i++) {
			
			CCTV c = cctvList.get(i);
			if(c.type==2) {
				for(int j=0; j<2; j++) {
					c.direction = j;
					dfs(depth+1, i+1);
				}
			}else if(c.type==5) {
				dfs(depth+1, i+1);
			}else {
				for(int j=0; j<4; j++) {
					c.direction = j;
					dfs(depth+1, i+1);
				}
			}
		}
		
	}
	private static int getResult() {
		int result = 0;
		
		//깊은 복사
		int arr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			System.arraycopy(map[i], 0, arr[i], 0, M);
		}
		
		boolean visited[][] =new boolean[N][M];
		for(int i=0; i<cctvList.size(); i++) {
			CCTV c = cctvList.get(i);
			int cx = c.x;
			int cy = c.y;
			int dir = c.direction;
			bfs(c.type, cx,cy, dir,arr, visited);
			
			visited =new boolean[N][M];
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0)
					result++;
			}
		}
		return result;
	}
	private static void bfs(int type, int cx, int cy, int dir, int[][] arr, boolean[][] visited) {
		q.add(new Detect(cx,cy));
		visited[cx][cy] = true;
		while(!q.isEmpty()) {
			Detect d = q.poll();
			int qx = d.x;
			int qy = d.y;
			if(type==1) {
				int dx = qx+nx[dir];
				int dy = qy+ny[dir];
				
				if(dx>=0 && dy>=0 && dx<N && dy< M && 
						map[dx][dy] != 6 && !visited[dx][dy]) {
					arr[dx][dy] = -1;
					q.add(new Detect(dx,dy));
					visited[dx][dy] = true;
				}
				
			}else if(type==2) {
				for(int i=0; i<2; i++) {
					int dx = qx+nx[dir+i*2];
					int dy = qy+ny[dir+i*2];
					if( dx>=0 && dy>=0 && dx<N && dy< M &&
							map[dx][dy] != 6 && !visited[dx][dy]) {
						arr[dx][dy] = -1;
						q.add(new Detect(dx,dy));
						visited[dx][dy] = true;
					}
				}
				
			}else if(type==3) {
				for(int i=0; i<2; i++) {
					int nnx = nx[(dir+i)%4];
					int nny = ny[(dir+i)%4];
					int dx = qx+nnx;
					int dy = qy+nny;
					
					if((dx==cx || dy==cy) && dx>=0 && dy>=0 && dx<N && dy< M &&
							map[dx][dy] != 6  && !visited[dx][dy]) {
						arr[dx][dy] = -1;
						q.add(new Detect(dx,dy));
						visited[dx][dy] = true;
					}
				}
			}else if(type==4) {
				for(int i=0; i<3; i++) {
					int dx = qx+nx[(dir+i)%4];
					int dy = qy+ny[(dir+i)%4];
					
					if((dx==cx || dy==cy) && dx>=0 && dy>=0 && dx<N && dy< M &&
							map[dx][dy] != 6  && !visited[dx][dy]) {
						arr[dx][dy] = -1;
						q.add(new Detect(dx,dy));
						visited[dx][dy] = true;
					}
				}
			}else if(type==5) {
				for(int i=0; i<4; i++) {
					int dx = qx+nx[i];
					int dy = qy+ny[i];
					if((dx==cx || dy==cy) && dx>=0 && dy>=0 && dx<N && dy< M &&
						map[dx][dy] != 6 && !visited[dx][dy]) {
						arr[dx][dy] = -1;
						q.add(new Detect(dx,dy));
						visited[dx][dy] = true;
					}
				}
			}
		}
		
	}

}
