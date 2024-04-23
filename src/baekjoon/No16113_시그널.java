package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No16113_시그널 {
	static int[][] numberX = {{0,0,0,0,0,1,1,2,2,2,2,2}, {0,0,0,0,0}, {0,0,0,0,1,1,1,2,2,2,2}, {0,0,0,1,1,1,2,2,2,2,2}, {0,0,0,1,2,2,2,2,2},
			{0,0,0,0,1,1,1,2,2,2,2}, {0,0,0,0,0,1,1,1,2,2,2,2}, {0,1,2,2,2,2,2},{0,0,0,0,0,1,1,1,2,2,2,2,2},{0,0,0,0,1,1,1,2,2,2,2,2}};
	static int[][] numberY = {{0,1,2,3,4,0,4,0,1,2,3,4}, {0,1,2,3,4}, {0,2,3,4,0,2,4,0,1,2,4}, {0,2,4,0,2,4,0,1,2,3,4}, {0,1,2,2,0,1,2,3,4}, 
			{0,1,2,4,0,2,4,0,2,3,4}, {0,1,2,3,4,0,2,4,0,2,3,4}, {0,0,0,1,2,3,4},{0,1,2,3,4,0,2,4,0,1,2,3,4},{0,1,2,4,0,2,4,0,1,2,3,4}};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		System.out.println(line);
		int cols = line.length()/5;
		char[][] arr = new char[5][cols];
		
		for(int i=0; i<5; i++) {
			arr[i] = line.substring(i*cols, i*cols+cols).toCharArray();
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<cols; i++) {
			if(arr[0][i] == '#') {
				boolean check = false;
				for(int j=0; j<10; j++) {
					
					for(int k=0; k<numberX[j].length; k++) {
						
						int nx = numberX[j][k] + i;
						int ny = numberY[j][k];
						if(ny < 0 || ny >=cols || arr[ny][nx]=='.') continue;
						
						if(k==(numberX[j].length-1)) {
							check = true;
							break;
						}
						
					}
					
					if(check) {
						sb.append(j);
						i += (j==0 ? 1 : 3);
						break;
					}
				}
				
			}
		}
		System.out.println(sb);
	}

}
