package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1789_수들의합 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		int cnt = 0;
		
		long sum = 0;
		long increase = 1;
		while(sum < num) {
			
			sum += increase++;
			
			cnt++;
			
		}
		if(sum > num) {
			cnt--;
		}
		System.out.println(cnt);
	}

}
