package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No19637_IF문좀대신써줘 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		ArrayList<String> names = new ArrayList<>();
		ArrayList<Long> limit = new ArrayList<>();
		
		for(int i=0; i< N ; i++ ) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			long num = Long.parseLong(st.nextToken());
			
			if((limit.size() == 0) || limit.get(limit.size()-1) != num) {
				names.add(name);
				limit.add(num);
			}
		}
		for(int i=0; i<M; i++) {
			long num = Long.parseLong(br.readLine());
			
			
			int start = 0;
			int end = names.size()-1;
			
			
			int mid;
			while(start <= end) {
				mid = (start+end)/2;
				if(num > limit.get(mid)) {
					start = mid+1;
				} else {
					end = mid -1 ;
				}
				
			}
			
			sb.append(names.get(start)).append("\n");
			
		}
		System.out.println(sb.toString());
		
		

	}

}
