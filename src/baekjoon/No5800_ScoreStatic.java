package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No5800_ScoreStatic {
	
	static StringTokenizer st;
	static ArrayList<Integer> score;
	static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int K = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=K; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			 score = new ArrayList<Integer>();
			for(int j=0; j<N; j++) {
				score.add(Integer.parseInt(st.nextToken()));
			}
			
			
			sb.append("Class " + i).append("\n");
			sb.append("Max "+Collections.max(score)+", Min "+Collections.min(score)+", Largest gap " + largestGap()).append("\n");
		}
		System.out.println(sb);
	}
	private static int largestGap() {
		Collections.sort(score);
		int max = -1;
		for(int i=0; i<score.size()-1; i++) {
			if(score.get(i+1)-score.get(i) > max)
				max = score.get(i+1)-score.get(i);
		}
		return max;
	}

}
