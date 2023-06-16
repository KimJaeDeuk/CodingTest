package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1343_폴리오미노 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String board = br.readLine();
		
		char[] line = new char[board.length()];
		
		for(int i=0; i<line.length; i++) {
			line[i] = board.charAt(i);
		}
		int len = line.length;
		int startNum = 0;
		boolean start = true;
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		for(int i=0; i<len; i++) {
			
			if(line[i]=='X') {
				if(start) {
					startNum = i;
					start = false;
				}
				cnt++;
				if(cnt%4==0) {
					sb.append("AAAA");
					cnt=0;
				}
			}else {
				
				if(cnt!=0 && cnt%2==0) {
					sb.append("BB");
					cnt=0;
				}
				else if(cnt%2==1) {
					System.out.println(-1);
					System.exit(0);
				}
				sb.append(".");
			}
		}
		if(cnt!=0 && cnt%2==0) {
			sb.append("BB");
		}else if(cnt%2==1) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(sb);
	}

}
