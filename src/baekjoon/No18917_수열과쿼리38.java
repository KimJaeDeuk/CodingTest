package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No18917_수열과쿼리38 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		long sum = 0;
		long xor = 0;
		while(M-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			int ope = Integer.parseInt(st.nextToken());
			if(ope==1) {
			
				long ad = Long.parseLong(st.nextToken());
				
				sum += ad;
				xor = xor ^ ad;
			} else if(ope==2) {
				long rm = Long.parseLong(st.nextToken());
				
				sum -= rm;
				xor = xor^rm;
			} else if(ope==3) {
				sb.append(sum).append("\n");
			}else {
				
				sb.append(xor).append("\n");
				
			}
			
			
		}
		System.out.println(sb);
	}

}
