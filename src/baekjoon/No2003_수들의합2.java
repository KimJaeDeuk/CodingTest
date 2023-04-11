package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2003_수들의합2 {
	
	static long M;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			
			long sum = 0;
			for(int j=i; j<N; j++) {
				sum += arr[j];
				if(sum==M) {
					cnt++;
					break;
				}
				if(sum>M) {
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
