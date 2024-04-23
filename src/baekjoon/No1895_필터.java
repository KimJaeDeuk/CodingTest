package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1895_필터 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int T = Integer.parseInt(br.readLine());
		
		int filter[][] = new int[R-2][C-2];
		ArrayList<Integer> middleValue;
		int cnt = 0;
		for(int i=0; i<R-2; i++) {
			for(int j=0; j<C-2; j++) {
				middleValue = new ArrayList<>();
				for(int a=i; a<i+3; a++) {
					for(int b=j; b<j+3; b++) {
						middleValue.add(arr[a][b]);
					}
					
				}
				Collections.sort(middleValue);
				if(middleValue.get(4) >= T) {
					cnt++;
				}
				
			}
		}
		System.out.println(cnt);
	}

}
