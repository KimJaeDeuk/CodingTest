package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1411_비슷한단어 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		int cnt = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				int[] alpha_1 = new int[26];
				int[] alpha_2 = new int[26];
				String left= arr[i];
				String right = arr[j];
				
				Arrays.fill(alpha_1,26);
				Arrays.fill(alpha_2,26);
				
				boolean check = false;
				for(int k=0; k<left.length(); k++) {
					int lIdx = left.charAt(k)-'a';
					int rIdx = right.charAt(k)-'a';
					
					if(alpha_1[lIdx] == 26 ) {
						alpha_1[lIdx] = lIdx - rIdx;
						
					} else if (alpha_1[lIdx] != (lIdx -rIdx)){
						check = true;
						break;
					} 
					if(alpha_2[rIdx] == 26 ) {
						alpha_2[rIdx] = rIdx - lIdx;
						
					} else if (alpha_2[rIdx] != (rIdx -lIdx)){
						check = true;
						break;
					} 
				}
				
				if(!check) cnt++;
				
			}
		}
		System.out.println(cnt);
	}

}
