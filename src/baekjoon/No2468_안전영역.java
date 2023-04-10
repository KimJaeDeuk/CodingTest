package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Place{
	int x;
	int y;
	Place(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class No2468_안전영역 {
	
	static boolean visited[][];
	static int arr[][];
	static int nx[] = {0,0,-1,1};
	static int ny[] = {1,-1,0,0};
	static int N;
	static int cnt = 0;
	static int max = 0;
	static Queue<Place> queue = new LinkedList<Place>();
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
			}
		}
		
		for(int i=0; i<max; i++) {
			int pCnt=0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(!visited[j][k] && arr[j][k] > i) {
						bfs(j,k, i);
						pCnt++;
					}
				}
			}
			visited = new boolean[N][N];
			cnt = Math.max(pCnt, cnt);
		}
		System.out.println(cnt);
	}


	private static void bfs(int i, int j, int depth) {
		queue.add(new Place(i, j));
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Place p = queue.poll();
			
			int qx = p.x;
			int qy = p.y;
			
			for(int k=0; k<4; k++) {
				
				int dx = qx+nx[k];
				int dy = qy+ny[k];
				
				if(dx <0 || dy<0 || dx>=N || dy>=N) continue;
				
				if(!visited[dx][dy] && arr[dx][dy] > depth) {
					visited[dx][dy] = true;
					queue.add(new Place(dx,dy));
				}
			}
		}
		
		
	}


}
