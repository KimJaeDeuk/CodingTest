package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1065_한수 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s_num = br.readLine();
		int i_num = Integer.parseInt(s_num);
		if(i_num < 100) {
			System.out.println(i_num);
			return;
		}else {
			getHansu(i_num);
			
		}

	}

	private static void getHansu(int i_num) {
		int cnt = 99;
		
		for(int i=100; i<=i_num; i++) {
			
			String s_i = String.valueOf(i);
			int up = 10;
			boolean cntPlus = true;
			up = Integer.parseInt(s_i.substring(0,1)) - Integer.parseInt(s_i.substring(1,2)); 
			
			
			for(int j=1; j<s_i.length()-1; j++) {
				
					if(Integer.parseInt(s_i.substring(j,j+1))-up != Integer.parseInt(s_i.substring(j+1,j+2))) {
						cntPlus =false;
						break;
					}
				
			}
			if(cntPlus) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}

}
