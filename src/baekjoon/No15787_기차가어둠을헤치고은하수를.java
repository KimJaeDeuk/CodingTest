package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15787_기차가어둠을헤치고은하수를 {
	static int N;
	static int T;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int[][] train = new int[N+1][22];
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int type =Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(type==1) {
				int seat = Integer.parseInt(st.nextToken());
				if(train[num][seat] == 0) {
					train[num][seat] = 1;
				}
			}else if(type==2) {
				int seat = Integer.parseInt(st.nextToken());
				if(train[num][seat] != 0) {
					train[num][seat] = 0;
				}
			}else if(type==3) {
				for(int j=20; j>=1; j--) {
					train[num][j] =  train[num][j-1];
				}
				
			}else if(type==4) {
				for(int j=1; j<=20; j++) {
					train[num][j] =  train[num][j+1];
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=1; i<=N ;i++) {
			int sum = 0;
			for(int j=1; j<=20; j++) {
				if(train[i][j]==0) continue;
				sum+=train[i][j]<<(j-1);
			}
			if(!list.contains(sum)) {
				list.add(sum);
			}
		}
		
		System.out.println(list.size());
	}

}
