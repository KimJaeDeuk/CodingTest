package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13458_시험감독 {
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr =new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int B= Integer.parseInt(st.nextToken());
		int C= Integer.parseInt(st.nextToken());
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int cnt = arr[i] - B;
			sum++;
			
			if(cnt<=0) continue;
			
			if(cnt%C==0) {
				sum += cnt/C;
			}else {
				sum += cnt/C + 1;
			}
		}
		System.out.println(sum);
	}

}
