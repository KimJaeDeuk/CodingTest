package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10973_BeforeNumber {
//todo
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		boolean isChange = false;
//		for(int i=N-1; i>=0; i--) {
//			for(int j=i-1; j>)
//		}
	}

}
/*
 * 1 2 3 4
 * 1 2 4 3
 * 1 3 2 4
 * 1 3 4 2
 * 2 1 3 4
 * 2 1 4 3
 * 2 3 1 4
 * 2 3 4 1
 * 2 4 1 3
 * 2 4 3 1
 * 3
 * 
 */