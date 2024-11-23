package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15702_중간고사채점 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] score = new int[N];
		for(int i=0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxStudent = Integer.MAX_VALUE;
		int maxScore = Integer.MIN_VALUE;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int studentNo = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int j=0; j<N; j++) {
				if(st.nextToken().equals("O")) {
					sum += score[j];
				}
			}
			if(maxScore <= sum) {
				if(maxScore == sum) {
					maxStudent = Math.min(maxStudent, studentNo);
				} else {
					maxScore = sum;
					maxStudent = studentNo;
				}
			}
		}
		
		sb.append(maxStudent).append(" ").append(maxScore);
		System.out.println(sb);
	}

}
