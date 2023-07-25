package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No5_수열편집 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				char c = st.nextToken().charAt(0);
				
				if(c=='I') {
					int x = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					
					list.add(x,num);
				}else if(c=='D') {
					
					int x =Integer.parseInt(st.nextToken());
					list.remove(x);
				}else if(c=='C') {
					int x = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					
					list.set(x, num);
				}
				
			}
			sb.append("#").append(tc).append(" ");
			if(L < list.size()) {
				sb.append(list.get(L));
			}else {
				sb.append("-1");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
