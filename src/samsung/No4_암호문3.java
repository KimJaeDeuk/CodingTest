package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No4_암호문3 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				char c = st.nextToken().charAt(0);
				
				if(c=='I') {
					
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++) {
						int num = Integer.parseInt(st.nextToken());
						list.add(x+j,num);
					}
				}else if(c=='D') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for(int j=0; j<y; j++) {
						list.remove(x);
					}
				}else if(c=='A') {
					int y = Integer.parseInt(st.nextToken());
					
					for(int j=0; j<y; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
				
			}
			
			sb.append("#").append(tc);
			
			for(int i=0; i<10; i++) {
				sb.append(" ").append(list.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
