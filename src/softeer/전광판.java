package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전광판 {
	static boolean[][] light = {{true, true, true, false, true, true, true},
			{false, false, true, false, false, true, false},
			{true, false, true, true, true, false, true},
			{true, false, true,true, false, true, true},
			{false, true, true, true, false, true, false},
			{true, true, false, true, false, true, true},
			{true, true, false, true, true, true, true},
			{true, true, true, false, false, true, false},
			{true, true, true, true, true, true, true},
			{true, true, true, true, false, true, true}};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String left = st.nextToken();
			String right = st.nextToken();
			
			while(left.length() < 5) {
				left = "-"+left;
			}
			while(right.length() < 5) {
				right = "-"+right;
			}
			int cnt = 0;
			for(int i=0; i<5; i++) {
				if(left.charAt(i) == right.charAt(i)) {
					continue;
				}
				
				if(left.charAt(i) == '-') {
					boolean targetLight[] = light[right.charAt(i)-'0'];
					for(int j=0;j<7; j++) {
						if(targetLight[j]) {
							cnt++;
						}
					}
				}
				else if(right.charAt(i) =='-') {
					boolean targetLight[] = light[left.charAt(i)-'0'];
					for(int j=0;j<7; j++) {
						if(targetLight[j]) {
							cnt++;
						}
					}
				}else {
					
					boolean targetLeft[] = light[left.charAt(i)-'0'];
					boolean targetRight[] = light[right.charAt(i)-'0'];
					
					for(int j=0;j<7; j++) {
						if(targetLeft[j] != targetRight[j]) {
							cnt++;
						}
					}
					
					
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
