import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws Exception{
	//	long before = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		String str = "";
		Queue<Pos> queue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			str = br.readLine();
			for(int j=0; j<M; j++) {
				char c = str.charAt(j);
				
				if(c== 'I') {
					queue.add(new Pos(i,j));
					visited[i][j] = true;
				}
				map[i][j] = c;
			}
		}
		int cnt = 0;
		while(!queue.isEmpty()) {
			
			Pos p = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + p.x;
				int ny = dy[i] + p.y;
				
				if(nx<0 || ny <0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny] == 'X') continue;
				
				queue.add(new Pos(nx,ny));
				visited[nx][ny] = true;
				
				if(map[nx][ny]=='P') {
					cnt++;
				}
			}
		}
		if(cnt == 0) {
			sb.append("TT");
		} else {
			sb.append(cnt);
		}
		System.out.println(sb);
	//	long after = System.currentTimeMillis();
		
	//	System.out.println(after - before);
	}

}