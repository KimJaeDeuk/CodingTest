
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish>{
	int x;
	int y;
	int dist;
	Fish(int x, int y, int dist){
		this.x =x;
		this.y = y;
		this.dist = dist;
	}
	@Override
	public int compareTo(Fish o) {
		if(this.dist == o.dist) {
			if(this.x == o.x) {
				return this.y < o.y ? -1 : 1;
			}
			return this.x < o.x ? -1 : 1;
		}
		return this.dist < o.dist ? -1 : 1;
		
	}
	
}

public class Main {

	//static Queue<Fish> Que = new LinkedList<Fish>();
	
	static Queue<Fish> fish = new LinkedList<Fish>();	//작은 물고기 담는 곳
	static int nx[] = {0,0,-1,1};
	static int ny[] = {1,-1,0,0};
	static boolean[][] visited;
	static int[][] arr;
	static int sec=0;
	static int size = 2;
	static int N;
	static int sx;
	static int sy;
	static int upSizeCnt=0;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) {
					sx = i;
					sy = j;
				}

			}
		}
		while(true) {
			visited = new boolean[N][N];
			if(!bfs()) {
				
				System.out.println(sec);
				return;
			}

			
		}


	}
	private static boolean bfs() {
		int min=Integer.MAX_VALUE;
		PriorityQueue<Fish> Que = new PriorityQueue<>();
		fish.add(new Fish(sx,sy,0));
    
		visited[sx][sy] = true;
		while(!fish.isEmpty()) {

			Fish f = fish.poll();
			int qx = f.x;
			int qy = f.y;
			int qDist = f.dist;
			for(int i=0; i<4; i++) {
				int dx = nx[i] + qx;
				int dy = ny[i] + qy;

				if(dx<0 || dy<0 || dx>=N || dy>=N) {
					continue;
				}
				int dDist = qDist+1;

				if(!visited[dx][dy] && size >= arr[dx][dy]) {
					visited[dx][dy] = true;
					fish.add(new Fish(dx,dy,dDist));
					if(size > arr[dx][dy] && arr[dx][dy] != 0)
						Que.add(new Fish(dx,dy,dDist));
				}

			}
		}
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;
		if(Que.isEmpty()) {
			return false;
		}	
		else {
			Fish f = Que.poll();
			minx = f.x;
			miny = f.y;
			sec += f.dist;
			upSizeCnt++;
			if(upSizeCnt==size) {
				size++;
				upSizeCnt = 0;
			}
		}
		
		arr[sx][sy] = 0;
		sx = minx;
		sy = miny;
		arr[minx][miny] = 9;
		

		return true;
	}




}
/*
 * 
//		else if(Que.size()!=1) {
//			for(Fish f : Que) {
//				if(min >= f.dist) {
//					if(min == f.dist) {
//
//						if(minx >= f.x) {
//
//							if(minx == f.x) {
//								minx = f.x;
//								if(miny > f.y) {
//
//									miny = f.y;
//								}
//							}else {
//								minx = f.x;
//								miny = f.y;
//							} 
//
//						}
//
//
//					}else {
//
//						min = f.dist;
//						minx = f.x;
//						miny = f.y;
//					}
//				}		
//			}
//			
//			
//			sec += min;
//			upSizeCnt++;
//			if(upSizeCnt==size) {
//				size++;
//				upSizeCnt = 0;
//			}
//		
 * 
 */
