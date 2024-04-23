package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4108_지뢰찾기 {
	static int[] dx= {-1,-1,0,1,1,1,0,-1};
	static int[] dy= {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int R =  Integer.parseInt(st.nextToken());
			int C =  Integer.parseInt(st.nextToken());
			
			if(R==0) {
				System.out.println(sb.toString());
				break;
			}
			
			char[][] arr = new char[R][C];
			
			for(int i=0; i<R; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(arr[i][j]!= '*') {
						int cnt = 0;
						for(int k=0; k<8; k++) {
							int nx = i+dx[k];
							int ny = j+dy[k];
							
							if(nx >=0 && ny >= 0 && nx<R && ny<C && arr[nx][ny]=='*') {
								cnt++;
							}
						}
						arr[i][j] = (char)(cnt+'0');
					}
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			
		}

	}

}
