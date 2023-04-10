package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1769_Is_It_Multiple_of_Three {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String N = br.readLine();
		int cnt=0;
		while(N.length()>1) {
			cnt++;
			
			long sum=0;
			String s = String.valueOf(N);
			for(int i=0; i<s.length(); i++) {
				sum+=s.charAt(i)-'0';
				
			}
			N = String.valueOf(sum);
		}
		
		if(Integer.parseInt(N)%3==0) {
			sb.append(cnt).append("\n");
			sb.append("YES").append("\n");
		} else {
			sb.append(cnt).append("\n");
			sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}

}
