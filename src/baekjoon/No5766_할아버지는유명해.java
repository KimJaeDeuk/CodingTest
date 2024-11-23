package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No5766_할아버지는유명해 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
		
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0 && M == 0) {
				break;
			}
			int arr[] = new int[10001];
			int max = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[num]++;
					max = Math.max(arr[num], max);
				}
			}
			ArrayList<Integer> list = new ArrayList<>();
			int secondMax = 0;
			for(int i=1; i<10001; i++) {
				if(arr[i] == max) arr[i] = 0;
				else {
					secondMax = Math.max(secondMax, arr[i]);
				}
			}
			
			for(int i=1; i<10001; i++) {
				if(arr[i] == secondMax)
				list.add(i);
			}
			
			Collections.sort(list);
			for(int num : list) {
				sb.append(num).append(" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
