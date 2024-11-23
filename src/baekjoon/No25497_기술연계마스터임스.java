package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No25497_기술연계마스터임스 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String skill = br.readLine();
		int cnt = 0;
		int lSkill = 0;
		int sSkill = 0;
		for(int i=0; i<N; i++) {
			char c = skill.charAt(i);
			if(c=='L') {
				lSkill++;
			} else if(c=='R') {
				if(lSkill == 0 ) {
					break;
				}else {
					lSkill--;
					cnt++;
				}
			} else if(c=='S' ) {
				sSkill++;
			} else if(c=='K') {
				if(sSkill==0) {
					break;
				}
				sSkill--;
				cnt++;
			} else {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}

}
