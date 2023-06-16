package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2891_카약과강풍 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		Arrays.fill(arr, 1);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<S; i++) {
			arr[Integer.parseInt(st.nextToken())-1] = 0;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<R; i++) {
			arr[Integer.parseInt(st.nextToken())-1] = 2;
		}
		
		boolean[] borrow = new boolean[N];
		for(int i=0; i<N; i++) {
			
			if(arr[i]==0) {
				if(i==0) {
					
				}else if(i==N-1) {
					
				}
			}
			
		}
	}

}
