package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2828_getAppleGame {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int j = Integer.parseInt(br.readLine());
		int place = 1;
		int cnt = 0;
		
		for(int i=0; i<j; i++) {
			int apple = Integer.parseInt(br.readLine());
			
			if(apple >= place && apple <=place+M -1) {
				continue;
			}else {
				if(apple < place) {
					cnt += place - apple;
					place -= (place - apple);
				}else {
					int move  = apple - (place+M-1);
					cnt += move;
					place += move;
				}
				
				
			}
		}
		System.out.println(cnt);

	}

}
