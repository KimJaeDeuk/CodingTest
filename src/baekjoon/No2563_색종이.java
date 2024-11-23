package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2563_색종이 {
	static boolean[][] arr = new boolean[110][110];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(cnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i< x+10; i++) {
				for(int j = y; j<y+10; j++) {
					arr[i][j] = true;
				}
			}
		}
		int result = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]) result++;
			}
		}
		
		System.out.println(result);
	}

}
