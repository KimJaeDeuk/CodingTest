import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,x,y,K;
	
	static int[][] arr;
	static int[] nx = {0,0, -1, 1};
	static int[] ny = {1,-1, 0, 0};
	static int top = 1;
	static int front = 5;
	static int right = 3;
	static int[] ju = new int[6];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<K; i++) {
			int operation = Integer.parseInt(st.nextToken()) - 1;
			int dx = x+nx[operation];
			int dy = y+ny[operation];
			
			if(dx>=N || dx<0 || dy>=M || dy<0) continue;
			x = dx;
			y = dy;
			int tmp = 0;
			switch(operation) {
			case 0:
				tmp = top;
				top = 7-right;
				right = tmp;
				break;
			case 1:
				tmp = top;
				top = right;
				right = 7-tmp;
				break;
			case 2:
				tmp = top;
				top = front;
				front = 7-tmp;
				break;
			case 3:
				tmp = top;
				top = 7-front;
				front = tmp;
				break;
			}
			
			
			if(arr[dx][dy]==0) {
				arr[dx][dy] = ju[7-top-1];
			}else {
				ju[7-top-1] = arr[dx][dy];
				arr[dx][dy]=0;
			}
			sb.append(ju[top-1]).append("\n");
		}
		System.out.println(sb);
		
	}

}
