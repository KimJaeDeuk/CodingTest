package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1205_RankingList {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =  new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int score = Integer.parseInt(st.nextToken());
		
		int P = Integer.parseInt(st.nextToken());
		
		int[] scoreArr = new int[52];
		scoreArr[0] = Integer.MAX_VALUE;
		for(int i=1; i<=P; i++)
			scoreArr[i] = -1;
		if(N>0) {
		st = new StringTokenizer(br.readLine(), " ");
		
			for(int i=1; i<=N; i++) {
				scoreArr[i] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 0;
		for(int i=1; i<=P; i++) {
			if(scoreArr[i] < score) {
				idx = i;
				scoreArr[i] = score;
				break;
			}
		}
		int[] rank = new int[P+1];
		rank[0] = 1;
		for(int i=1; i<=P; i++) {
			if(scoreArr[i] == scoreArr[i-1]) {
				rank[i] = rank[i-1];
			}
			else if(scoreArr[i] < scoreArr[i-1]) {
				rank[i] = i;
			}
			
			if(i==idx) {
				System.out.println(rank[i]);
				return;
			}
		}
		System.out.println("-1");
	}

}
