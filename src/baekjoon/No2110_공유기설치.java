package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2110_공유기설치 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		long sub[] = new long[C];
		sub[0] = arr[0];
		sub[C-1] = arr[N-1];
		
		for(int i=0; i<C-2; i++) {
			
			
			
		}
		
		
	}

}
