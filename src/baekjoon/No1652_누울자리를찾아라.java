package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1652_누울자리를찾아라 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =  Integer.parseInt(br.readLine());
		
		char[][] arr =new char[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {	
				arr[i][j] = line.charAt(j);  
			}
		}
		int row = 0;
		int col = 0;
		int rCnt = 0;
		int cCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(arr[i][j]=='.') {
					rCnt++;
				}
				
				if(rCnt>=2 && (arr[i][j]=='X' || j==N-1)) {
					rCnt = 0;
					row++;
				}
				if(arr[i][j]=='X' || j==N-1) {
					rCnt=0;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[j][i]=='.') {
					cCnt++;
				}
				
				if(cCnt>=2 && (arr[j][i]=='X' || j==N-1)) {
					cCnt = 0;
					col++;
				}
				if(arr[j][i]=='X' || j==N-1) {
					cCnt=0;
				}
			}
		}
		System.out.println(row+" " + col);
	}

}
