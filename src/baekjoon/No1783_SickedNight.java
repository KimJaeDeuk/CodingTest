package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1783_SickedNight {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int cnt = 1;

		if(N==1) {
			System.out.println(cnt);
		}
		else if(N==2) {
			int i=0;
			for(i=1; i<=M; i+=2) {
				if(cnt==4) {
					System.out.println(cnt);
					return;
				}
				
				cnt++;
				
			}
			System.out.println(cnt-1);
		}
		else {
			
			if(M<6) {	
				int result = M==5 ? 4 : M;
				System.out.println(result);
				return;
			}
			System.out.println(M-2);
		}
	
	}

}
