package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No12933_오리 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		char sound[] = line.toCharArray();
		boolean visited[] = new boolean[line.length()];
		
		
		int maxSound = 0;
		char[] duck = {'q','u','a','c','k'};
		int idx = 0;
		int duckCnt = 0;
		boolean fal = false;
		
		while(maxSound <= line.length()/5) {
			int cnt = 0;
			maxSound++;
			boolean check = false;
			for(int i=0; i<sound.length; i++) {
				
				if(sound[i]==duck[idx] && !visited[i]) {
					
					idx = (idx+1)%5;
					cnt++;
					visited[i] = true;
				}
				
				
			}
			
			if(cnt%5==0 && cnt!=0) {
				duckCnt++;
			}else if(cnt%5!=0){
				fal = true;
				break;
			}
			
			
			
			
		}
		if(fal) {
			System.out.println(-1);
		}else
			System.out.println(duckCnt);

	}

}
