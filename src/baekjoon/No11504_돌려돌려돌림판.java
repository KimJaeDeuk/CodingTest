package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11504_돌려돌려돌림판 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(tc-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N= Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			int X[] = new int[M];
			int Y[] = new int[M];
			
			for(int i=0; i<M; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for(int i=0; i<N; i++) {
				int u = 0;
				boolean check = true;
				int a = 0;
				int j=0;
				for(j=0; j<M; j++) {
					int idx = (i+j)%M;
					if(arr[idx] > X[j] && arr[idx] < Y[j]) {
						check = false;
						break;
						
					}else if(arr[idx] < X[j] && arr[idx] >Y[j]) {
						break;
					}
					
				} 

				if(!check || j == M-1) cnt++;
				
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}

}
