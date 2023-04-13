package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No6986_절사평균 {
	static int N;
	static int K;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		double arr[] = new double[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		Arrays.sort(arr);
		double jeol = 0.0;
		double bo = 0.0;
		
		for(int i=K; i<N-K; i++) {
			jeol += arr[i];
		}
		
		for(int i=0; i<N; i++) {
			if(i<K) {
				bo+=arr[K];
			}else if(i>=N-K) {
				bo += arr[N-K-1];
			}else
				bo += arr[i];
			
		}
		
		System.out.printf("%.2f\n%.2f",jeol/(N-(K*2)), bo/N);
	}

}
