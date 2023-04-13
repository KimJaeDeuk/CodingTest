package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato2{
	int x;
	int y;
	int h;
	public Tomato2(int h, int x, int y) {
		this.h = h;
		this.x = x;
		this.y = y;
	}
}

public class No7569_토마토 {
	
	static int[] nx = {0,0,-1,1,0,0};
	static int[] ny = {1,-1,0,0,0,0};
	static int[] nh = {0,0,0,0,1,-1};
	static Queue<Tomato2> queue = new LinkedList<Tomato2>();
	static int[][][] arr;
	static int X,Y,H;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][X][Y];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<X; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k=0; k<Y; k++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j][k] = num;
				
					if(num == 1) {
						queue.add(new Tomato2(i,j,k));
					}
				}
			}
		}
		
		
		int result  = bfs();
		System.out.println(result);						
	}
	private static int bfs() {
		
		while(!queue.isEmpty()) {
			Tomato2 t = queue.poll();
			int th = t.h;
			int tx = t.x;
			int ty = t.y;
			
			for(int i=0; i<6; i++) {
				int dh = th+nh[i];
				int dx = tx+nx[i];
				int dy = ty+ny[i];
				
				if(dx<0 || dy<0 || dh < 0 || dx>=X || dy >= Y || dh >= H || arr[dh][dx][dy]==-1) continue;
				
				if(arr[dh][dx][dy]==0) {
					queue.add(new Tomato2(dh,dx,dy));
					arr[dh][dx][dy] = arr[th][tx][ty]+1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<X;j++) {
				for(int k=0; k<Y; k++) {
					if(arr[i][j][k]==0) return -1;
					else if(arr[i][j][k]>=1) max = Math.max(max, arr[i][j][k]);
				}
			}
		}
		return max-1;

	}
	

}
