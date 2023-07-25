package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3_동아리실관리하기 {
	static final int MOD = 1000000007;
	static int dp[][];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=test_case; tc++) {
			
			String line = br.readLine();
			
			dp = new int[line.length()][16];
			
			setFisrtDay(dp, line);
			
			for(int i=1; i<line.length(); i++) {
				setOtherDay(dp, line, i, tc);
			}
			
			int result = 0;
			
			for(int i=1; i<16; i++) {
				result += dp[dp.length-1][i];
				result %= MOD;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
	private static void setOtherDay(int[][] dp, String line, int day, int tc) {
		int key = 1 << (line.charAt(day)-'A');
		
		for(int yester=1; yester<16; yester++) {
			
			if(dp[day-1][yester] > 0) { // 전날에서 파생된 경우가 있을 때
				
				for(int today=1; today<16; today++) {	//다음날의 15가지 ( 0 ) 제외 경우를 비교
					if((today&key) > 0  && (yester&today) > 0) {
						
						dp[day][today] += dp[day-1][yester];
						dp[day][today] %= MOD;
					} 
					
				}
				
			}
			
		}
	}
	private static void setFisrtDay(int[][] dp, String line) {
		
		int key = 1 << (line.charAt(0) -'A');
		
		for(int i=1; i<16; i++) {
			if((i&key)>0 && (i&1)>0) {
				dp[0][i]= 1;
			}
		}
	}

}
/*
 *  0 0 0 0
 *  
 *  8 4 2 1
 *  D C B A
 *  
 *  A B
 *  
 *  A 
 */
