package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No22351_수학은체육과목입니다3 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		
		int startNum = findStartNum(line);
		int endNum = findEndNum(line);

	}

	private static int findEndNum(String line) {
		
		
		
		
		return 0;
	}

	private static int findStartNum(String line) {
		int max = line.length() > 4 ? 4 : line.length();
		
		// i = 1의자리, 2의자리 3의자리
		for(int i=1; i<=max; i++) {
			int jari = 1;
			int startNum = Integer.parseInt(line.substring(0,i));
			if(startNum%10==9) jari++;
			int nextNum = Integer.parseInt(line.substring(i, i+jari));
			System.out.println("start: "+ startNum + ", next: " + nextNum);
			if(startNum +1 == nextNum) {
				startNum = nextNum;
				int cnt = 0;
				for(int j=i+jari; j<=line.length()-jari; j+=jari) {
					System.out.println(j + " "+ (line.length() - jari) + " " + (j + jari));
					if(nextNum%10 == 9) {
						jari++;
					}
					int next = Integer.parseInt(line.substring(j, j+jari));
					if(next != nextNum +1) break;
					nextNum = next;
					System.out.println(next);
					if(++cnt >=4) {
						return startNum;
					}
				}
				
			} 
			
		}
		return 0;
	}

}
