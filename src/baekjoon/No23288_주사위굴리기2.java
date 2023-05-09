package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Dice{
	int x;
	int y;
	public Dice(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class No23288_주사위굴리기2{
	static int diceR = 3;
	static int diceF = 5;
	static int diceU = 1;
	static int dir = 0;
	static int dx[] = {0,1,0,-1};	//0 : 동 1 : 남 2 : 서 3 : 북
	static int dy[] = {1,0,-1,0};
	static int arr[][];
	static int N,M,K;
	static int nowX=0;
	static int nowY=0;
	static Queue<Dice> queue = new LinkedList<Dice>();
	static int total=0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			moveDice();
			bfs(new boolean[N][M]);
			changeDirection();
		}
		System.out.println(total);
	}
	
	private static void changeDirection() {
		int place = arr[nowX][nowY];
		int bottom = 7-diceU;
		if(bottom > place) {
			dir = (dir+1)%4;
		}else if(bottom < place) {
			dir = (dir+3)%4;
		}
	}

	private static void bfs(boolean visited[][]) {
		int cnt = 0;
		visited[nowX][nowY] = true;
		queue.add(new Dice(nowX,nowY));
		while(!queue.isEmpty()) {
			Dice d = queue.poll();
			int qx = d.x;
			int qy = d.y;
			cnt++;
			
			for(int k=0; k<4; k++) {
				int nx = qx+dx[k];
				int ny = qy+dy[k];
				if(nx<0 || ny<0 || nx>=N|| ny>=M || arr[nowX][nowY]!=arr[nx][ny] || visited[nx][ny]) continue;
				
				visited[nx][ny]= true;
				queue.add(new Dice(nx,ny));
			}
		}
		total += cnt*arr[nowX][nowY];
		
	}

	//이동방향으로 한칸 굴러가고 만약 이동방향에 칸이 없다면 이동방향을 반대로 한 다음 한칸 굴러간다.
	private static void moveDice() {
		
		int nx = nowX+dx[dir];
		int ny = nowY+dy[dir];
		//한칸 구르기
		if(nx<0 || ny < 0 || nx>=N || ny>=M) {
			dir = (dir+2)%4;
			nowX = nowX + dx[dir];
			nowY = nowY + dy[dir];
		}else {
			nowX = nx;
			nowY = ny;
		}
		
		//주사위 숫자 바꾸기
		if(dir==0) {
			int tmp = diceU;
			diceU = 7-diceR;
			diceR = tmp;
		}else if(dir==1) {
			int tmp = diceU;
			diceU = 7-diceF;
			diceF = tmp;
		}else if(dir==2) {
			int tmp = diceU;
			diceU = diceR;
			diceR = 7-tmp;
		}else {
			int tmp = diceU;
			diceU = diceF;
			diceF = 7-tmp;
		}
		
	}

}
