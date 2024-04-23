package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No11558_TheGameOfDeath {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			int idx = 1;
			int cnt = 1;
			boolean check = false;
			while(arr[idx] != N) {
				cnt++;
				idx = arr[idx];
				
				if(cnt > N) {
					sb.append(0).append("\n");
					check =true;
					break;
				}
			}
			if(!check) {
				sb.append(cnt).append("\n");
			}
			/*
			 * 사람 지목 cnt
			 * 1   2    1 
			 * */ 
		}
		
		System.out.println(sb);
	}

}
