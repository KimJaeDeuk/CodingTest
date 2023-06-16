package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2669_직사각형네개의합집합 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		boolean arr[][] = new boolean[101][101];
		for(int i=0; i<4; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			int ux = Integer.parseInt(st.nextToken());
			int uy = Integer.parseInt(st.nextToken());
			
			for(int a=dx; a<ux; a++) {
				for(int b=dy; b<uy; b++) {
					arr[a][b] = true;
				}
			}
		}
//		for(int i=10; i>=0; i--) {
//			for(int j=10; j>=0; j--) {
//				if(arr[i][j]) {
//					System.out.print("o ");
//				}else {
//					System.out.print("x ");
//				}
//				
//			}
//			System.out.println();
//		}
		int cnt=0;
		for(int i=1; i<101; i++) {
			for(int j=1; j<101;j++) {
				
					if(arr[i][j])
						cnt++;
				
			}
		}
		System.out.println(cnt);

	}

}
