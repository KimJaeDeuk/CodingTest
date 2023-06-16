package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3060_욕심쟁이돼지 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(TC-->0) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			long[] arr = new long[6];
			long feed = 0;
			for(int i=0; i<6; i++) {
				arr[i] = Long.parseLong(st.nextToken());
				feed +=arr[i];
			}
			
			
			
			int day = 1;
			while(feed <=N) {
				long newArr[] = new long[6];
				feed = 0;
				for(int i=0; i<6; i++) {
					long beside = arr[(6+i-1)%6] + arr[(6+i+1)%6] + arr[(6+i+3)%6] + arr[i]; 
					
					newArr[i] = beside;
					feed += beside; 
				}
				
				arr = newArr.clone();
				day++;
			}
			
			
			sb.append(day).append("\n");
		}
		System.out.println(sb);
	}

}
