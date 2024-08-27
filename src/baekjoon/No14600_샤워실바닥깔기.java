package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14600_샤워실바닥깔기 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int max = (int)Math.pow(2, k);
		int arr[][] = new int[max+1][max+1];
		
		int tileNum = 1;
		StringBuilder sb = new StringBuilder();
		
		for(int i=max; i>=1; i-=2) {
			for(int j=1; j<=max; j+=2) {
				boolean check = setArr(arr, i, j, x, y, tileNum++, sb);
				if(!check) {
					int x_line = 0;
					if(i>2) {
						x_line = 3;
					} else {
						x_line = 2;
					}
					if(j>2) {
						arr[x_line][3] = tileNum;
					} else {
						arr[x_line][2] = tileNum;
					}
				}
			}
			
		}

		for(int i=max; i>=1; i--) {
			for(int j=1; j<=max; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static boolean setArr(int[][] arr, int start_x, int start_y, int x, int y, int tileNum, StringBuilder sb) {
		boolean isHole = false;
		for(int i=start_x; i>=start_x-1; i--) {
			for(int j=start_y; j<=start_y+1; j++) {
				if(i == y && j == x) {
					arr[i][j] = -1;
					isHole = true;
				} else {
					arr[i][j] = tileNum;
				}
			}
		}
		return isHole;
	}

}
