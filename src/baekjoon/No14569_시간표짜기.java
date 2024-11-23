package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No14569_시간표짜기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> classList = new ArrayList<>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int[] arr = new int[cnt];
			for(int j=0; j<cnt; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			classList.add(arr);
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			boolean arr[] = new boolean[51];
			
			for(int j=0; j<cnt; j++) {
				arr[Integer.parseInt(st.nextToken())] = true;
			}
			int possible = 0;
			for(int j=0; j<N; j++) {
				int[] classArr = classList.get(j);
				boolean check = false;
				for(int k= 0; k<classArr.length; k++) {
					if(!arr[classArr[k]]) {
						check = true;
						break;
					}
					
					
				}	
				if(!check) possible++;
			}
			sb.append(possible).append("\n");
		}

		
		System.out.println(sb.toString());
	}

}
