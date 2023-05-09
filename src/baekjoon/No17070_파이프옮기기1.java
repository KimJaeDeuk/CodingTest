package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pipe{
	int x;
	int y;
	int type;
	public Pipe(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;	//type 1 : 가로 | 2 : 세로 | 3 : 대각선
	}
}

public class No17070_파이프옮기기1 {
	
	static int N = 0;
	static int arr[][];
	static Queue<Pipe> queue = new LinkedList<Pipe>();
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		StringTokenizer st;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(cnt);
	}
	private static void bfs() {
		queue.add(new Pipe(1,2,1));
		
		while(!queue.isEmpty()) {
			Pipe p = queue.poll();
			int px = p.x;
			int py = p.y;
			int pType = p.type;
			if(px==N && py==N) {
				cnt++;
			}else {
				if(pType==1 || pType==3) {
					if(py+1<=N && arr[px][py+1]==0) {
						queue.add(new Pipe(px, py+1, 1));
					}
					
				}
				if(pType==2 || pType==3) {
					if(px+1<=N && arr[px+1][py]==0) {
						queue.add(new Pipe(px+1, py, 2));
					}
				}
				if(px+1<=N && py+1<=N && arr[px+1][py]==0 && arr[px][py+1]==0 && arr[px+1][py+1]==0) {
					queue.add(new Pipe(px+1, py+1, 3));
				}
			}
		}
	}

}
