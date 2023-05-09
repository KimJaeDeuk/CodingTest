package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14890_경사로 {
	static int arr[][];
	static int N,L;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			int before = arr[i][0];
			int height = arr[i][0];
			int j;
			for(j=1; j<N; j++) {
				if(Math.abs(arr[i][j-1] - arr[i][j])>1) break;
				
				if(before - arr[i][j] == 0 ) continue;
				
				
				before = arr[i][j];
			}
		}
	}

}
