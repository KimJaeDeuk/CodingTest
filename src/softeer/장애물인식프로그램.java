package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 장애물인식프로그램 {
	static boolean[][] visited;
	static int[] nx = {0,0,-1,1};
	static int[] ny = {1,-1,0,0};
	static char[][] arr;
	static int N;
	static ArrayList<Integer> resultList = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == '1' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(resultList.size());
		
		Collections.sort(resultList);
		
		for(Integer num : resultList) {
			System.out.println( num );
		}
	}
	private static void bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		int cnt = 1;
		while(!queue.isEmpty()) {
			
			int[] q = queue.poll();
			
			for(int k=0; k<4; k++) {
				int dx = q[0] + nx[k];
				int dy = q[1] + ny[k];
				
				if(dx >=0 && dy>=0 && dx<N && dy < N && !visited[dx][dy] && arr[dx][dy] == '1') {
					queue.add(new int[] {dx,dy});
					visited[dx][dy] = true;
					cnt++;
				}
			}
			
		}
		
		resultList.add(cnt);
		
		
	}

}
