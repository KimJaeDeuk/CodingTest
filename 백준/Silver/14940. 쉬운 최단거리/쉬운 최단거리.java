import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pos{
		int x;
		int y;
		int dist;
		Pos(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	static int[][] map, result;
	static int N, M;
	static Queue<Pos> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		map = new int[N][M];
		result = new int[N][M];
		for(int i=0; i<N; i++) {
			Arrays.fill(result[i], -1);
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 2) {
					queue.add(new Pos(i,j,0));
					visited[i][j] = true;
					result[i][j] = 0;
				}
				if(num == 0) {
					result[i][j] = 0;
				}
				map[i][j] = num;
			}
		}
		
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void bfs() {
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = dx[i]+pos.x;
				int ny = dy[i]+pos.y;
				
				if(nx >=N || ny >=M || nx<0 || ny<0 || visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				queue.add(new Pos(nx,ny,pos.dist+1));
				result[nx][ny] = pos.dist+1;
				visited[nx][ny] = true;
				
			}
		}
		
	}

}
