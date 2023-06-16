package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2512_예산 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		long M = Long.parseLong(br.readLine());
		
		long left = 1;
		
		long right = max;
		
		while(left<=right) {
			
			long sum = 0;
			long mid = (left+right)/2;
			
			for(long n : arr) {
				if(n>mid) {
					sum += mid;
				}else {
					sum += n;
				}
				
			}
			
			if(sum > M) {
				right = mid -1;
			}else {
				left = mid +1;
			}
			
			
		}
		System.out.println(right);
	}

}
