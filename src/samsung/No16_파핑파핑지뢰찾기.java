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
	static int[][] map;
	static Queue<Mine> queue = new LinkedList<Mine>();
	static int cnt;
	static int noMineCnt;
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("res/16_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String line;
		for(int tc=1; tc<=test_case; tc++) {
			int N = Integer.parseInt(br.readLine());
			cnt=0;
			noMineCnt=0;
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				line = br.readLine();
				for(int j=0; j<N; j++) {
					if(line.charAt(j)=='.') {
						map[i][j] =  0 ;
						noMineCnt++;
					}else {
						map[i][j] = -1;
					}
					
				}
			}
			
			
			
			sb.append("#").append(tc);
			
			//1차적으로 가장자리가 아니면서 방문하지 않았고 0인경우 bfs를 돌려 확산시키기
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					if(map[i][j]==0 && !visited[i][j]) {
						
						queue.add(new Mine(i,j));
						visited[i][j] = true;
						bfs();
					
					}
				}
			}
			//이후에 noMineCnt값만큼 cnt를 더해준다.
			
			sb.append(cnt+noMineCnt);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		
		while(!queue.isEmpty()) {
			
			Mine m = queue.poll();
			
			int qx = m.x;
			int qy = m.y;
			cnt++;
			noMineCnt--;
			
			for(int k=0; k<8; k++) {
				
				int dx = qx+nx[k];
				int dy = qy+ny[k];
				
				
			}
		}
		
		
	}

}
