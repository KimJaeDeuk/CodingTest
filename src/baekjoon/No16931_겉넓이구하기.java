package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16931_겉넓이구하기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][][] = new int [102][N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				for(int k=0; k<num; k++) {
					arr[k][i][j] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<M; j++) {
				int idx = 0;
				while(arr[idx][i][j]!=0) {
					//아랫면
					if(idx==0 ) {	
						cnt++;
					}
					
					//뒷면
					if(i-1 < 0) {
						cnt++;
					}
					else if(i-1>=0 && arr[idx][i-1][j]==0) {
						cnt++;
					}
					
					if(j-1 <0 )
						cnt++;
					else if(j-1>=0 && arr[idx][i][j-1]==0) {
						cnt++;
					}
					
					if(i+1==N)
						cnt++;
					else if(i+1<N && arr[idx][i+1][j]==0) {
						cnt++;
					}
					
					if(j+1==M)
						cnt++;
					else if(j+1<M && arr[idx][i][j+1]==0) {
						cnt++;
					}
					
					if(arr[idx+1][i][j]==0) {
						cnt++;
					}
					
					
						
					idx++;
				}
				
			}
			
		}
		System.out.println(cnt);
		
	}

}
