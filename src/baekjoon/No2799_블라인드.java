package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2799_블라인드 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M, N;
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		char[][] arr = new char[5*M+1][5*N+1];
		for(int i=0; i<5*M+1; i++) {
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		int[] result = new int[5];
		
		
		for(int i=0; i<M; i++) {
			
			for(int j=0; j<N; j++) {
				int x = i*5+1; 
				int y = j*5+1;
				int cnt = 0;
				for(int k=0; k<4; k++) {
					if(arr[x+k][y]=='*') {
						cnt++;
					}
				}
				result[cnt]++;
				
			}
			
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i : result) sb.append(i).append(" ");
		System.out.println(sb);
		
	}

}
