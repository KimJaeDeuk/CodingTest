package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato{
	int x;
	int y;
	
	tomato(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class No7576_Tomato {

	static int N;
	static int M;
	
	static int[] nx = {0,0,-1,1};
	static int[] ny = {-1,1,0,0};
	static int same = 0;
	static Queue<tomato> tq = new LinkedList<tomato>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean check = true;
		int[][] tomato = new int[M][N];
		int[][] visited = new int[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1)
					tq.add(new tomato(i,j));
			}
		}
		
			System.out.println( bfs(tomato,visited));
	
	}
	
	private static int bfs(int[][] tomato, int[][] visited) {
		
		while(!tq.isEmpty()) {
			
			tomato t = tq.poll();
			
			int x = t.x;
			int y = t.y;
			
			for(int i=0; i<4; i++) {
				int dx = nx[i]+x;
				int dy = ny[i]+y;
				
				if(dx>=0 && dy>=0 && dx<M && dy < N ) {
					if(tomato[dx][dy] == 0) {
						tq.add(new tomato(dx,dy));
						
						tomato[dx][dy] = tomato[x][y]+1;
					}
				}
			}
			
			
		}
		
		int result = Integer.MIN_VALUE;
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(tomato[i][j]==0)
					return -1;
				if(tomato[i][j]>0) {
					result = Math.max(result, tomato[i][j]);
				}
			}
		}
		if(result==1)
			return 0;
		return result-1;
		
	}
	


}
