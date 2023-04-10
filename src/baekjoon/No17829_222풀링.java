package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No17829_222풀링 {
	static int N;
	static int arr[][];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int multi = 1;
		while(multi != N) {
			for(int i=0; i<N/multi; i+=2) {
				for(int j=0; j<N/multi; j+=2) {
					arr[i/2][j/2] = getSecond(arr[i][j], arr[i][j+1], arr[i+1][j], arr[i+1][j+1]);
				}
			}
			
			
			
			
			multi *= 2;
		}
		
		System.out.println(arr[0][0]);
		
	}
	private static int getSecond(int i, int j, int k, int l) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		Collections.sort(list);
		
		
		return list.get(2);
	}

}
