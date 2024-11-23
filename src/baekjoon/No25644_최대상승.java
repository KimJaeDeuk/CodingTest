package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No25644_최대상승 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i=0; i<N; i++) {
			int curr = Integer.parseInt(st.nextToken());
			max = Math.max(max, curr - min);
			min = Math.min(curr, min);
		}
		System.out.println(max);
		
		
	}

}
