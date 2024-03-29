package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15_프로세서연결하기 {
	static int N;
	
	static int min_lane;
	static int max_conn;
	static ArrayList<int[]> list;
	static int[][] arr;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/15_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[13][13];
		int test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= test_case; tc++) {
			N = Integer.parseInt(br.readLine());
			min_lane = Integer.MAX_VALUE; max_conn = 0;
			int cnt = 0;
			list = new ArrayList<int[]>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==1) {
						if(i==0 || j==0 || i==N-1 || j==N-1) {
							cnt++;
						}else
							list.add(new int[] {i,j});
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			dfs(0,cnt, 0);
			sb.append(min_lane);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int n, int conn, int len) {
		
		if(n==list.size()) {
			
			if(max_conn < conn) {
				max_conn = conn;
				min_lane = len;
				
				
			}else if(max_conn == conn) {
				min_lane = Math.min(len,min_lane); 
			}
			
			return;
		}
		
	
		int[] co = list.get(n);

		
		for(int k=0; k<4; k++) {
			
			int nx = co[0];
			int ny = co[1];
			boolean check = false;
			
			while(nx + dx[k] <N && ny + dy[k] < N && nx + dx[k] >= 0 && ny + dy[k] >= 0) {
				nx += dx[k];
				ny += dy[k];
				
				if(arr[nx][ny]==1 || arr[nx][ny]==2) {
					check = true;
					break;
				}
			}
			if(check) { 
				dfs(n+1, conn, len);
			}else {
				nx = co[0];
				ny = co[1];
				int cnt = 0;
				while(nx + dx[k] <N && ny + dy[k] < N && nx + dx[k] >= 0 && ny + dy[k] >= 0) {
					nx += dx[k];
					ny += dy[k];
					arr[nx][ny] = 2;
					cnt++;
				}
				dfs(n+1, conn+1, len+cnt);
				
				nx = co[0];
				ny = co[1];
				
				while(nx + dx[k] <N && ny + dy[k] < N && nx + dx[k] >= 0 && ny + dy[k] >= 0) {
					nx += dx[k];
					ny += dy[k];
					arr[nx][ny] = 0; 
				}
			}
		}
		
	}
	
}
