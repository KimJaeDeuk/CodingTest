package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17204_죽음의게임 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		int start = 0;
		for(int i=0; i<N; i++) {
			
			cnt++;
			start = arr[start];
			if(start==K) {
				System.out.println(cnt);
				System.exit(0);
			}
			
			
		}

		System.out.println(-1);
		
	}

}
