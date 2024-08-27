package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class No21921_블로그 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] visit = new int[N+1];
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			visit[i] = visit[i-1] + num;
			
		}
		
		int cnt = 1;
		for(int i=X; i<=N; i++) {
			
			if(visit[i] - visit[i-X] > max) {
				max = visit[i] - visit[i-X];
				cnt = 1;
			} else if(visit[i] - visit[i-X] == max) {
				cnt++;
			}
		}
		
		
		if(max == 0) {
			System.out.println("SAD");
		} else {
			
			System.out.println(max);
			
			System.out.println(cnt);
		}
		
	}

}
