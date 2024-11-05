package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연탄의크기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(arr);
		int result = Integer.MIN_VALUE;
		for(int i=2; i<=arr[n-1]; i++) {
			int cnt = 0;
			for(int j=0; j<n; j++) {
				
				if(arr[j] % i == 0 ) {
					cnt++;
				}
			}
			result = Math.max(cnt, result);	
		}
		System.out.println(result);
	}

}
