package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Map{
	int x;
	int y;
	int count;
	Map(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class No2589_보물섬 {

	static int nx[] = {0,0,-1,1};
	static int ny[] = {1,-1,0,0};
	static boolean visited[][];
	static char map[][];
	static int N;
	static int M;
	static int min = Integer.MIN_VALUE;
	
	static Queue<Map> queue = new LinkedList<Map>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			
			for(int j=0; j<line.length(); j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L') {
					int bfsResult = bfs(i,j);
					result = Math.max(bfsResult, result);
					visited = new boolean[N][M];
				}
			}
		}
		System.out.println(result);
	}

	private static int bfs(int i, int j) {
		int min = 0;
		
		visited[i][j] = true;
		queue.add(new Map(i, j,0));
		while(!queue.isEmpty()) {
			
			Map pos = queue.poll();
			int qx = pos.x;
			int qy = pos.y;
			int qCount = pos.count;
			int qSize = queue.size();
			for(int k=0; k<4; k++) {
				int dx = qx + nx[k];
				int dy = qy + ny[k];
				
				if(dx <0 || dy < 0 || dx>=N || dy >=M || visited[dx][dy] || map[dx][dy]=='W') continue;
				
				visited[dx][dy] = true;
				
				queue.add(new Map(dx,dy, qCount+1));
			}
			if(qSize == queue.size()) {
				min = Math.max(qCount, min);
			}
			
		}
		return min;
	}

}
