package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16918_BomberMan {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt( st.nextToken());
		int C = Integer.parseInt( st.nextToken());
		int N = Integer.parseInt( st.nextToken());
		
		char[][] arr = new char[R][C];
		char[][] arr2 = new char[R][C];
		char[][] arr3 = new char[R][C];
		int[][] time = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				arr[i][j] = line.charAt(j);
				if(line.charAt(j)=='.') {
					arr2[i][j] = 'O';
				}else {
					arr2[i][j] = '.';
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]=='O') {
					if(i>0)
						arr2[i-1][j] = '.';
					if(i<R-1)
						arr2[i+1][j] = '.';
					if(j>0)
						arr2[i][j-1] = '.';
					if(j<C-1)
						arr2[i][j+1] = '.';
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				arr3[i][j] = arr2[i][j]=='O' ? '.' : 'O';
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr2[i][j]=='O') {
					if(i>0)
						arr3[i-1][j] = '.';
					if(i<R-1)
						arr3[i+1][j] = '.';
					if(j>0)
						arr3[i][j-1] = '.';
					if(j<C-1)
						arr3[i][j+1] = '.';
				}
			}
		}
		
		if(N!=0 && N%2==0) {
			String all = "";
			for(int i=0; i<C; i++) {
				all+="O";
			}
			for(int i=0; i<R; i++) {
				sb.append(all).append("\n");
			}
		}
		else if(N==0 || N==1) {
			for(int i=0; i<R; i++) {
				sb.append(arr[i]).append("\n");
			}
		}
		else if(N > 1 && N%4==3){
			
			
			for(int i=0; i<R; i++) {
				sb.append(arr2[i]).append("\n");
			}
		}
		else if(N > 1 && N%4==1){
			
			for(int i=0; i<R; i++) {
				sb.append(arr3[i]).append("\n");
			}
		}
		System.out.println(sb);
		
	}

}
