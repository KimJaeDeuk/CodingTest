
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class People{
	int x;
	int y;
	People(int x, int y){
		this.x =x;
		this.y = y;
	}
}


public class Main {
	
	static Queue<People> queue = new LinkedList<People>();
	static Queue<People> move = new LinkedList<People>();
	static boolean[][] visited;
	static int[][] arr;
	static int[] nx = {0,0,-1,1};
	static int[] ny = {1,-1,0,0};
	static int N;
	static int L;
	static int R;
	static int cnt=0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			boolean check=false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {		//open
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {	
						if(bfs(i,j)) {
							check =true;
						}
					}
				}
			}
			
			if(!check) {
				System.out.println(cnt);
				return;
			}else {
				cnt++;
			}
		}
		
		
	}
	private static boolean bfs(int i, int j) {
		queue.add(new People(i,j));
		visited[i][j] = true;
		boolean check = false;
		boolean one = true;
		int sum=0;
		int aaa=1;
		sum = arr[i][j];
		while(!queue.isEmpty()) {
			People p = queue.poll();
			int qx = p.x;
			int qy = p.y;
			
			for(int k=0; k<4; k++) {
				int dx = nx[k]+qx;
				int dy = ny[k]+qy;
				
				if(dx<0 || dy<0 || dx>=N || dy>=N) {
					continue;
				}
				int minus = Math.abs(arr[qx][qy] - arr[dx][dy]);
				
				if(!visited[dx][dy] && minus<=R && minus>=L) {
					visited[dx][dy] = true;
					if(one) move.add(new People(qx,qy));
					move.add(new People(dx,dy));
					sum+=arr[dx][dy];
					aaa++;
					check = true;
					queue.add(new People(dx,dy));
				}
				
			}
		}
		int a = move.size();
		if(check) {
			while(!move.isEmpty()) {
				People m = move.poll();
				arr[m.x][m.y] =  sum/aaa;
				
			}
		}
		return check;
	}

}











