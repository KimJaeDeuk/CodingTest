package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No20125_쿠키의신체측정 {
	static int[] dx = {0, 0, 1, 1, 1};
	static int[] dy = {-1, 1, 0, 0, 0};
	static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		char[][] cookies = new char[N+1][N+1];
		int hx = 0, hy = 0;
		boolean isFirst= false;
		for(int i=1; i<=N; i++) {
			String line = br.readLine();
			
			for(int j=1; j<=N; j++) {
				cookies[i][j] = line.charAt(j-1);
				if(cookies[i][j]=='*' && !isFirst) {
					isFirst = true;
					hx = i +1;
					hy = j;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(hx).append(" ").append(hy).append("\n");
		int bLength= 0;
		for(int i=0; i<5; i++) {
			int bx = hx + bLength;
			int by = hy + ((i==3) ? -1 : (i==4) ? 1 : 0);
			int cnt = 0;
			while(true) {
				bx += dx[i];
				by += dy[i];
				
				if(bx>N || by> N || bx<1 || by<1 || cookies[bx][by]!='*') break;
				cnt++;
				
				
			}
			if(i==2) {
				bLength = cnt;
			}
			sb.append(cnt).append(" ");
		}
		System.out.println(sb);
	}
	
}
