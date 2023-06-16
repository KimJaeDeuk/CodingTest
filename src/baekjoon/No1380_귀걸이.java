package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1380_귀걸이 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cnt=0;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N==0) break;
			cnt++;
			String[] name = new String[N];
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				name[i] = br.readLine();
			}
			
			for(int i=0; i<2*N-1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int num = Integer.parseInt(st.nextToken());
				String alpha = st.nextToken();
				
				arr[num-1]++;
			}
			
			for(int i=0; i<N; i++) {
				if(arr[i]<2) {
					sb.append(cnt).append(" ").append(name[i]).append("\n");
					break;
				}
			}
			
		}
		
		
		System.out.println(sb);
	}

}
