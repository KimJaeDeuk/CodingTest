package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No11637_인기투표 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<T; i++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int arr[] = new int[n+1];
			
			for(int j=1; j<=n; j++) {
				arr[j] = Integer.parseInt(br.readLine());
			}
			
			sb.append(getWinner(n, arr)).append("\n");
		}
		System.out.println(sb);
	}

	private static String getWinner(int n, int[] arr) {
		int max = 0;
		int idx = 0;
		for(int i=1; i<=n; i++) {
			max = Math.max(arr[i], max);
		}
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(max == arr[i]) { 
				cnt++;
				idx = i;
			} 
		}
		if(cnt > 1) {
			return "no winner";
		}
		int other = 0;
		for(int i=1; i<=n; i++) {
			if(i==idx) continue;
			other += arr[i];
		}
		
		if(max > other) {
			return "majority winner " +idx; 
		}else {
			return "minority winner " + idx;
		}
	}

}
