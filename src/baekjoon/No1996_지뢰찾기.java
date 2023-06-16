package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Z{
	int x;
	int y;
	Z(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class No1996_지뢰찾기 {
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int dx[] = {0,1,1, 1, 0,-1,-1,-1};
	static int dy[] = {1,1,0,-1,-1,-1, 0, 1};
	static boolean[][] visited;
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		boolean wlfhl[][] = new boolean[N][N]; 
		ArrayList<Z> list = new ArrayList<Z>();
		for(int i=0; i<N; i++) {
			String l = br.readLine();
			for(int j=0; j<N; j++) {
				if(l.charAt(j)=='.') {
					arr[i][j] = 0;
					list.add(new Z(i,j));
				}else {
					arr[i][j] = l.charAt(j)-'0';
					visited[i][j] = true;
				}
			}
		}
		
		for(Z z : list) {
			int cnt = 0;
			for(int k=0; k<8; k++) {

				int nx = dx[k] + z.x;
				int ny = dy[k] + z.y;
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || !visited[nx][ny]) continue;
				
				
				cnt += arr[nx][ny];
				
			}
			arr[z.x][z.y] = cnt;
		}
		StringBuilder sb = new StringBuilder();
		char result[][] = new char[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) {
					sb.append("*");
				}else {
					if(arr[i][j]>=10) {
						sb.append("M");
					}else {
						sb.append(arr[i][j]);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				if(arr[i][j]=='.') {
//					bfs(i,j);
//				}
//			}
//		} 
//		for(Z z : list) {
//			arr[z.x][z.y]= '*'; 
//		}
//		while(!queue.isEmpty()) {
//			int[] a = queue.poll();
//			arr[a[0]][a[1]] = a[2] < 10 ?  String.valueOf(a[2]).charAt(0) : 'M';
//		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
	}

	private static void bfs(int i, int j) {
		
		int cnt = 0;
		for(int k=0; k<8; k++) {
			
			int nx = dx[k] + i;
			int ny = dy[k] + j;
			
			if(nx<0 || ny<0 || nx>=N || ny>=N ) continue;
			
			if(arr[nx][ny]!='.') {
				int c = arr[nx][ny]-'0';
				cnt += c;
			}
			
		}
		
		queue.add(new int[] {i,j,cnt});
		

		
	}

}
