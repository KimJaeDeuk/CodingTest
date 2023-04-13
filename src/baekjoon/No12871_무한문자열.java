package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No12871_무한문자열 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		int s_length = s.length();
		int t_length = t.length();
		int max = 0;
		for(int i=Math.min(s_length, t_length); i>=1; i--) {
			
			if(s_length %i==0 && t_length %i == 0) {
				max = i;
				break;
			}
		}
		
		int min =( s_length * t_length ) / max;
		int slen = min/s_length;
		int tlen = min/t_length;
		
		String change_s = "";
		String change_t = "";
		
		for(int i=0; i<slen; i++) {
			change_s += s;
		}
		for(int j=0; j<tlen; j++) {
			change_t += t;
		}
		if(change_s.equals(change_t)) {
			System.out.println(1);
		}else
			System.out.println(0);
		
	}

}
