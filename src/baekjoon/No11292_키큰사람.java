package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class No11292_키큰사람 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				System.out.println(sb.toString());
				break;
			}
			StringBuilder tc = new StringBuilder();
			ArrayList<String[]> info = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				String line[] = br.readLine().split(" ");
				info.add(line);
				
			}
			String max = Collections.max(info, new Comparator<String[]>() {

				@Override
				public int compare(String[] o1, String[] o2) {
					
					return o1[1].compareTo(o2[1]);
				}
				
			})[1];
			
			for(String height[] : info) {
				if(height[1].equals(max)) {
					tc.append(height[0]).append(" ");
				}
			}
			
			sb.append(tc.toString().trim()).append("\n");
		}
	}

}
