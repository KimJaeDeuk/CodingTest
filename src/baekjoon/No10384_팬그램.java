package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10384_팬그램 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=N; tc++) {
			String line = br.readLine();
			int[] arr = new int[26];
			
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i)>='A' && line.charAt(i)<='Z') {
					arr[line.charAt(i)-'A']++;
				}else if(line.charAt(i)>='a' && line.charAt(i)<='z') {
					arr[line.charAt(i)-'a']++;
				}
			}
			boolean check = true;
			int pangram = Integer.MAX_VALUE;
			sb.append("Case ").append(tc).append(": ");
			for(int i=0; i<arr.length; i++) {
				
				pangram = Math.min(arr[i], pangram);
			}
			if(pangram==0) {
				sb.append("Not a pangram");
			}
			else if(pangram==1) {
				sb.append("Pangram!");
			}else if(pangram==2) {
				sb.append("Double pangram!!");
			}else {
				sb.append("Triple pangram!!!");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
