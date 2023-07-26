package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Mine{
	int x;
	int y;
	public Mine(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class No16_파핑파핑지뢰찾기 {
	static final int nx[] = {1,1,1,-1,-1,-1,0,0};
	static final int ny[] = {0,1,-1,0,1,-1,1,-1};
	static boolean visited[][];
	static char[][] map;
	static int[][] safe;
	static Queue<Mine> queue;
	static int N;
	static int cnt;
	static int noMineCnt;
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("res/16_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String line;
		for(int tc=1; tc<=test_case; tc++) {
			N = Integer.parseInt(br.readLine());
			cnt=0;
			noMineCnt=0;
			map = new char[N][N];
			safe=  new int[N][N];
			visited = new boolean[N][N];
			queue = new LinkedList<Mine>();
			for(int i=0; i<N; i++) {
				line = br.readLine();
				map[i] = line.toCharArray();
			}
			
			setMineCnt();
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(safe[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			//0인 mine을 눌러보기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(safe[i][j]==0 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
//					}else if(safe[i][j]!=-1 && !visited[i][j]) {
//						cnt++;
//					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++) {
					if(safe[i][j]!=-1 && !visited[i][j])
						cnt++;
				}
			}
			sb.append("#").append(tc).append(" ");
			
			sb.append(cnt);
			
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void bfs(int i, int j) {
		queue.add(new Mine(i,j));
		
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			
			Mine m = queue.poll();
			int qx = m.x;
			int qy = m.y;
			
			int qCnt = 0;
			
			for(int k=0;k<8;k++) {
				
				int dx = nx[k]+qx;
				int dy = ny[k]+qy;
				
				if(dx<0 || dy<0 || dx>=N || dy>=N || visited[dx][dy]) continue;
				
				visited[dx][dy]=true;
				if(safe[dx][dy]==0) {
					queue.add(new Mine(dx,dy));
				}
			}
			
		}
		
	}
	private static void setMineCnt() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int mineCnt = 0;
				
				if(map[i][j]=='*') {
					safe[i][j] = -1;
					continue;
				}
				
				for(int k=0; k<8; k++) {
					int dx = nx[k]+i;
					int dy = ny[k]+j;
					
					if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
					
					if(map[dx][dy]=='*')
						mineCnt++;
				}
				safe[i][j] = mineCnt;
				
			}
		}
		
	}

	
}
