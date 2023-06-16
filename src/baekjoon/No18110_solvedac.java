package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No18110_solvedac {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int jul_avg = (int)Math.round(N*0.15);
		double sum = 0;
		for(int i=jul_avg; i<N-jul_avg; i++) {
			sum += arr[i];
		}
		
		System.out.println((int)Math.round(sum/(N-(jul_avg)*2)));
	}

}
