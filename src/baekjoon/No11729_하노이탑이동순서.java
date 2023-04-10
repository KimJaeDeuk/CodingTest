package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No11729_하노이탑이동순서 {
	
	static int N;
	static StringBuffer sb;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		
		dfs(N, 1, 2, 3);
		System.out.println(sb);
	}
	
	
	private static void dfs(int cnt, int start, int mid, int to) {
		if(cnt==1) {
			sb.append(start + " " + to).append("\n");
			return;
		}
		
		dfs(cnt-1, start, to, mid);
		
		sb.append(start+" " + to).append("\n");
		
		dfs(cnt-1, mid, start,to);
	}

}
