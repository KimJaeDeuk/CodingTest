package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No4396_지뢰찾기 {
	static int dx[] = {0,0, -1,-1, -1, 1,1,1};
	static int dy[] = {1,-1,0,1,-1,0,1,-1};
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char arr[][] = new char[n][n];
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			
			for(int j=0; j<n; j++) {
				arr[i][j] = line.charAt(j);
				if(arr[i][j]=='*') {
					list.add(new int[]{i,j});
				}
			}
		}
		char result[][] = new char[n][n];
		boolean open = false;
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				char c = line.charAt(j);
				
				if(c=='.') {
					result[i][j] = '.';
				}
				
				if(arr[i][j]!='.' && c=='x') {
					open = true;
				}
				
				if(c=='x' && arr[i][j]=='.') {
					int cnt = 0;
					for(int k=0; k<8; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
						
						if(arr[nx][ny]=='*') cnt++;
					}
					result[i][j] = (char)(cnt+'0');
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(open) {
			for(int[] a : list) {
				result[a[0]][a[1]] = '*';
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
