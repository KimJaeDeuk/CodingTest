package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class No2594_놀이공원 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+2][2];
		int start = 10*60;
		arr[0][0] = start;
		arr[0][1] = start;
		int finish = 22*60;
		arr[N+1][0] = finish;
		arr[N+1][1] = finish;
		for(int i=1; i<N+1; i++) {
			String[] a = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(a[0].substring(0,2))*60 + Integer.parseInt(a[0].substring(2,4)) - 10;
			arr[i][1] = Integer.parseInt(a[1].substring(0,2))*60 + Integer.parseInt(a[1].substring(2,4)) + 10;
		}
		
		Arrays.sort(arr, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[0], o2[0]) == 0 ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[1], o2[1]);
			}
			
		});
		ArrayList<int[]> list = new ArrayList<>();
		
		int max = Math.max(0, Math.max(arr[0][0] - start, finish - arr[N-1][1]));
		for(int i=0; i<N+1; i++) {
			int s_time = 0;
			int f_time = 0;
			for(int j=i+1; j<N; j++) {
				
				
				
			}
		}
		
		System.out.println(max);
	}

}
