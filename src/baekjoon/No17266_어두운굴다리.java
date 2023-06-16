package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17266_어두운굴다리 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int maxDist = 0;
		maxDist = Math.max(arr[0]*2 , (N - arr[M-1])*2);
		for(int i=0; i<M-1; i++) {
			int dif = arr[i+1]-arr[i];
			maxDist = Math.max(dif,maxDist);
			
		}
		System.out.println(maxDist%2+maxDist/2);
		
	}

}
