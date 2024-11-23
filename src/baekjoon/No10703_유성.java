package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10703_유성 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		char[][] arr =  new char[r][s];
		
		int lowStar = 0;
		
		int highFloor = r-1;
		
		for(int i=0; i<r; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int diff = r-1;
		
		for(int j=0; j<s; j++) {
			boolean check = false;
			for(int i=r-1; i>=0; i--) {
				
				if(arr[i][j]== 'X') {
					lowStar = i;
					check = true;
					break;
				}
				
			}
			if(check) {
				for(int i=lowStar+1; i<r; i++) {
					if(arr[i][j]=='#') {
						highFloor = i;
						diff = Math.min(diff, highFloor - lowStar - 1);
						break;
					}
				} 
			}
		}
		
		
		for(int j=0; j<s; j++) {
			for(int i=r-1; i>=0; i--) {
				
				if(arr[i][j]=='X') {
					arr[i][j] = '.';
					arr[i+diff][j] = 'X';
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<r; i++) {
			for(int j=0; j<s; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
