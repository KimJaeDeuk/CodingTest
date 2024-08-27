package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No20310_타노스 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] line = br.readLine().toCharArray();
		boolean[] isRemove = new boolean[line.length];
		int zeroNum = 0;
		int oneNum = 0;
		
		for(int i=0; i<line.length; i++) {
			if(line[i] == '0' ) {
				zeroNum++;
			} else {
				oneNum++;
			}
		}
		zeroNum /=2;
		oneNum /=2;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<line.length; i++) {
			if(oneNum == 0) break; 
			if(line[i] == '1') {
				isRemove[i] = true;
				oneNum--;
			}
		}
		
		for(int i=line.length-1; i>=0; i--) {
			if(zeroNum == 0) break; 
			if(line[i] == '0') {
				isRemove[i] = true;
				zeroNum--;
			}
		}
		
		for(int i=0; i<line.length; i++) {
			if(!isRemove[i]) sb.append(line[i]);
		}
		System.out.println(sb);
	}

}
