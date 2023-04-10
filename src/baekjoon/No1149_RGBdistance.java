package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1149_RGBdistance {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] price = new int[N+3][3];
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=2; i<=N; i++) {
			price[i][0] += Math.min(price[i-1][1], price[i-1][2]);
			price[i][1] += Math.min(price[i-1][0], price[i-1][2]);
			price[i][2] += Math.min(price[i-1][0], price[i-1][1]);
		}
		
		System.out.println(Math.min(price[N][0],Math.min(price[N][1],price[N][2])));
		
	}

}
