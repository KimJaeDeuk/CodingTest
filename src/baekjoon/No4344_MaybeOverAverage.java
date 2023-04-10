package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4344_MaybeOverAverage {
	static int C;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		C = Integer.parseInt(br.readLine());
		
		while(C-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			for(int i=0;i<N;i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(getAverage(score)).append("\n");
		}
		System.out.println(sb);
	}
	private static String getAverage(int[] score) {
		int sum=0;
		int avg;
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		avg = sum/N;
		int cnt=0;
		for(int i=0; i<score.length; i++) {
			if(score[i] > avg)
				cnt++;
		}
		
		
		return String.format("%.3f",(cnt / (double)score.length)*100 ) +"%";
	}

}
