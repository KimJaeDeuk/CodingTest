import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Ch{
	int x;
	int y;
	public Ch(int x, int y) {
		this.x =x ;
		this.y=y;
	}
}
public class Main {
	static int arr[][];
	static int N,M;
	static Queue<Ch> Q = new LinkedList<Ch>();
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int chCnt = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int hour = 0;
		while(check()) {
			hour++;
			bfs(new boolean[N][M]);
		}
		System.out.println(hour+"\n"+chCnt);

	}
	private static void bfs(boolean[][] vs) {
		Q.add(new Ch(0,0));
		vs[0][0] = true;
		ArrayList<Ch> list = new ArrayList<Ch>();
		while(!Q.isEmpty()) {
			Ch c = Q.poll();
			
			int qx = c.x;
			int qy = c.y;
			for(int i=0; i<4; i++) {
				int nx = qx+dx[i];
				int ny = qy+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || vs[nx][ny]) continue;
				vs[nx][ny]=true;
				if(arr[nx][ny]==0) {
					Q.add(new Ch(nx,ny));
				}else if(arr[nx][ny]==1) {
					list.add(new Ch(nx,ny));
				}
				
			}
		}
		chCnt = list.size();
		for(Ch c : list) {
			arr[c.x][c.y] = 0; 
		}
		
	}
	private static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1) {
					return true;
				}
			}
		}
		return false;
	}

}
