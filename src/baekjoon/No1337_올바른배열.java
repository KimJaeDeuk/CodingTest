package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No1337_올바른배열 {
	static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			
			list.add( Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		int min = 6;
		for(int i=0; i<N; i++) {
			int num = list.get(i);
			
			for(int j=0; j<5; j++) {
				int cnt = 5;
				for(int k=0; k<5; k++) {
					int change_num = num-j+k;
					if(change_num <0 || change_num > 1000000000) {
						break;
					}
					if(list.contains(change_num)) {
						cnt--;
					}
				}
				min = Math.min(cnt, min);
			}
		}
		System.out.println(min);
		
	}

}
