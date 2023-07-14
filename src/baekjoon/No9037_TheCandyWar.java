package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9037_TheCandyWar {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-->0) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num%2==1) {
					num++;
				}
				arr[i] = num;
			}
			int cnt = 0;
			while(check(arr)) {
				
				int newArr[] = new int[N];
				
				for(int i=0; i<N; i++) {
					newArr[i] = arr[(N+i-1)%N]/2;
				}
				
				for(int i=0; i<N; i++) {
					arr[i] = arr[i]/2 + newArr[i];
					if(arr[i]%2==1) arr[i]++;
				}
				
				
				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean check(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]!=arr[j]) {
					return true;
				}
			}
			
		}
		
		return false;
	}

}
