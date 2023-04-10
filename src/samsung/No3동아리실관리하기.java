package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No3동아리실관리하기 {
	static final int MOD = 1000000007;
	static int [][]dp;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int test_case = 1; test_case <=tc ; test_case++) {
			
			String line = br.readLine();
			
			dp = new int[line.length()][16];
			firstDay(line.charAt(0));
			
			for(int i=1; i<line.length(); i++) {
				otherDay(i, line.charAt(i));
			}
			
			int result=getResult(line.length()-1);
			
			sb.append("#"+test_case+" " + result).append("\n");
		}
		System.out.println(sb);
	}
	private static int getResult(int length) {
		int result = 0;
		for(int i=1; i<16; i++) {
			result += dp[length][i];
			result %= MOD;
		}
		return result;
	}
	private static void otherDay(int day, char k_char) {
		int key = 1 << k_char-'A';
		
		for(int i=1; i<16; i++) {
			if(dp[day-1][i]!=0) {
				for(int j=1; j<16; j++) {
					if((i&j)!=0 && (j&key) != 0 ) {
						dp[day][j] = dp[day][j]%MOD + dp[day-1][i] % MOD;
						dp[day][j] %=MOD;
					}
					
				}
			}
			
		}
		
	}
	private static void firstDay(char k_char) {
		
		int key = 1 << k_char-'A';
		
		for(int i=1; i<16; i++) {
			if((i&key)!=0 && (i&1)!=0) dp[0][i] = 1;
		}
		
	}

}
