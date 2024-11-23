package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2508_사탕박사고창영 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(T-->0) {
			br.readLine();
			
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			char arr[][] = new char[r][c];
			
			for(int i=0; i<r; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			int cnt = 0;
			for(int i=0; i<r; i++) {
				for(int j=0; j<c-2; j++) {
					if(arr[i][j]=='>' && j+2 <c && arr[i][j+1]=='o' && arr[i][j+2]=='<') {
						cnt++;
					}
				}
			}
			
			for(int i=0; i<c; i++) {
				for(int j=0; j<r-2; j++) {
					if(arr[j][i]=='v' && j+2 <r && arr[j+1][i]=='o' && arr[j+2][i]=='^') {
						cnt++;
					}
				}
			}
			
			
			
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);
	}

}
