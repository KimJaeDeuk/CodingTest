package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1515_수이어쓰기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int pointer = 0;
		int result = 0;
		while(result++ <= 30000){
			
			String rString = String.valueOf(result);
			
			for(int i = 0; i< rString.length(); i++) {
				if(rString.charAt(i) == N.charAt(pointer)) {
					pointer++;
				}
				if(pointer == N.length()) {
					System.out.println(result);
					return;
				}
			}
			
			
		}
		
	}

}
