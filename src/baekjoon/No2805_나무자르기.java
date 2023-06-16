package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805_나무자르기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		long max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i],max);
		}
		long left = 1;
		long right = max;
		long answer = 0;
		while(left <= right) {
			
			long sum = 0;
			long mid = (left + right) /2;
			
			for(long len : arr) {
				if(len-mid>0)
					sum += (len-mid);
			}
			
			if(sum < M) {
				right = mid-1;
			}else {
				left = mid +1;
				answer = Math.max(answer, mid);
			}
			
		}
		System.out.println(right);

	}

}
