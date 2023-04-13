package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16967_배열복원하기 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[H][W];
		int[][] B = new int[H+X][W+Y];
		
		for(int i=0; i<H+X; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<W+Y ;j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<H+X; i++) {
			for(int j=0; j<W+Y; j++) {
				if(i>=X && i<H && j>=Y && j<W) {	//겹치는 부분
					A[i][j] = B[i][j]- A[i-X][j-Y];
				}else if(i<X && j>=W || j<Y && i>=H) {	//안겹치는 부분
					continue;
				}else if(i < X || j < Y) {
					A[i][j] = B[i][j];
				}else if(i >= H || j >= W) {
					A[i-X][j-Y] = B[i][j];
				}
			}
		}
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
