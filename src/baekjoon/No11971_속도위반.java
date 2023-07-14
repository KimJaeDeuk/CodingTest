package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class No11971_속도위반 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] arr = new int[2][101];
		int num = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			
			int area = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			for(int k=num+1; k<=num+area; k++) {
				arr[0][k] = speed;
			}
			num +=area;
		
		}
		num = 0 ;
		int max = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int area = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			for(int k=num+1; k<=num+area; k++) {
				max = Math.max(max,speed-arr[0][k]);
				
			}
			num +=area;
			
		}
		System.out.println(max);

	}

}
