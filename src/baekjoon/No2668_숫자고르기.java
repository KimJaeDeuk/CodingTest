package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No2668_숫자고르기 {
	static int N;
	static int[] arr;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		
		for(int i=1; i<=N; i++) {
			if(!list.contains(i)) {
				dfs(i);
			}
		}
		
		
	}
	private static void dfs(int num) {
		
		
	}
}

	