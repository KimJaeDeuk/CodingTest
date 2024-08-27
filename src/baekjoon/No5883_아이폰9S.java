package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No5883_아이폰9S {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			int num = arr[i];
			
			int before = 0;
			int cnt = 1;
			for(int j=0; j<N; j++) {
				
				if(num == arr[j]) {
					continue;
				}
				
				if(before == 0) {
					before = arr[j];
				} else {
					
					if(before == arr[j]) {
						cnt++;
					} else {
						max = Math.max(cnt, max);
						cnt = 1;
						before = arr[j];
					}
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}

}
