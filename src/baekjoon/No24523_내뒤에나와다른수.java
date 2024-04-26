package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No24523_내뒤에나와다른수 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int arr [] = new int[N+1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer[] = new int[N+1];
		for(int i=N; i>=1; i--) {
			if(i==N) {
				answer[i] = -1;
			} else if(arr[i]==arr[i+1]) {
				answer[i] = answer[i+1];
			} else if(arr[i]!= arr[i+1]) {
				answer[i] = i+1;
			}
		}
		for(int i=1; i<=N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

}
