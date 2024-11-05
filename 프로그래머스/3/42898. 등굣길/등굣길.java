import java.util.*;
class Solution {
    private final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // 거리
        int[][] dp = new int[m+1][n+1];

        for(int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]]--;
        }
        dp[1][1] = 1;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if((i==1 && j==1) || dp[i][j] == -1) continue;

                if(i == 1 && dp[i][j-1] != -1) {
                    dp[i][j] = dp[i][j-1];
                }
                else if(j==1 && dp[i-1][j] != -1) {
                    dp[i][j] = dp[i-1][j];
                } else if(dp[i-1][j] == -1){
                    dp[i][j] = dp[i][j-1];
                } else if(dp[i][j-1] == -1) {
                    dp[i][j] = dp[i-1][j];
                } else if(dp[i][j-1] != -1 && dp[i-1][j] != -1){
                    dp[i][j] += dp[i][j-1] + dp[i-1][j];
                }
                
                dp[i][j] %= MOD;
            }
        }
        answer = dp[m][n];
        return answer;
    }
}