package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15720_카우버거 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int normal = 0;
		int discount = 0;
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int min = Math.min(Math.min(B, C),D);
		int burger[] = new int[B];
		int side[] = new int[C];
		int drink[] = new int[D];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<B; i++) {
			burger[i] = Integer.parseInt(st.nextToken());
			normal += burger[i];
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			side[i] = Integer.parseInt(st.nextToken());
			normal += side[i];
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<D; i++) {
			drink[i] = Integer.parseInt(st.nextToken());
			normal += drink[i];
		}
		
		Arrays.sort(burger);
		Arrays.sort(side);
		Arrays.sort(drink);
		
		for(int i=0; i<B; i++) {
			if(i+min>B-1) {
				discount += burger[i]*0.9; 
			}else {
				discount += burger[i];
			}	
		}
		for(int i=0; i<C; i++) {
			if(i+min>C-1) {
				discount += side[i]*0.9; 
			}else {
				discount += side[i];
			}	
		}
		for(int i=0; i<D; i++) {
			if(i+min>D-1) {
				discount += drink[i]*0.9; 
			}else {
				discount += drink[i];
			}	
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(normal).append("\n").append(discount);
		System.out.println(sb);
	}

}
