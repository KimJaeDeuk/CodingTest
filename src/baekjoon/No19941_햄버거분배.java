package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No19941_햄버거분배 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] done = new boolean[N];
		
		char[] pos = br.readLine().toCharArray();
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			
			if(pos[i] == 'P') {
				boolean eat = false;
				for(int j=K; j>0; j--) {
					if(i-j >=0 && pos[i-j]=='H' && !done[i-j] ) {
						eat = true;
						done[i-j] = true;
						cnt++;
						break;
					}
				}
				if(!eat) {
					for(int j=1; j<=K; j++) {
						if(i+j < N && pos[i+j]=='H' && !done[i+j] ) {
							done[i+j] = true;
							cnt++;
							break;
						}
					}
				}
			}
			
		}
		System.out.println(cnt);
	}

}
