package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14594_동방프로젝트 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N+1];
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=y; j>x; j--) {
				arr[j] = true;
			}
		}
		int cnt = 0;
		for(int i=1; i<=N; i++) if(!arr[i]) cnt++;
		System.out.println(cnt);
	}	

}
