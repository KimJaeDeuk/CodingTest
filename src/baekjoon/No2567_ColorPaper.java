package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2567_ColorPaper {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dx[] = {-1, 1, 0,0};
		int dy[] = {0, 0, -1, 1};
		
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		int[][] paper = new int[101][101];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x; j<x+10; j++) {
				for(int k = y; k<y+10; k++) {
					if(paper[j][k] == 0)
						paper[j][k] = 1;
				}
			}
		}
		
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				
				if(paper[i][j]==1) {
					
					for(int z = 0; z<4; z++) {
						int nx = i+dx[z];
						int ny = j+dy[z];

						if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || paper[nx][ny] == 0) {
							cnt++;
						}
						
					}
					
					
				}
			}
		}
		System.out.println(cnt);
			
	}

}
