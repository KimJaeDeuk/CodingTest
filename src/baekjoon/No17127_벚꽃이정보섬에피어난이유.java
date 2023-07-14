package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17127_벚꽃이정보섬에피어난이유 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] =new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		int max = 0;
		for(int i=0; i<N-3; i++) {
			boolean[] check = new boolean[N];
			int group = 1;
			for(int j=i; j<i+N-3; j++) {
				group *= arr[j];
				check[j] = true;
			}
			
			for(int j=0; j<N; j++) {
				if(!check[j]) {
					group += arr[j];
				}
			}
			max = Math.max(group, max);
			
		}
		System.out.println(max);
		
	}

}

/*
// 7  
 * 1 1 1 4
 * 1 1 2 3
 * 1 1 3 2
 * 1 1 4 1
 * 1 2 1 3
 * 
 */
