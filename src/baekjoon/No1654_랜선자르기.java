package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1654_랜선자르기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		
		int K = Integer.parseInt(st.nextToken());
		long N = Long.parseLong(st.nextToken());

		long arr[] = new long[K];
		long max = 0;
		for(int i=0; i<K; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		long left = 1;
		long right = max;
		
		while(left <=right) {
			long cnt = 0;
			long mid = (left+right)/2;
			
			for(long len : arr) {
				cnt += (len/mid);
			}
			
			if(cnt<N) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		System.out.println(right);
	}

}
