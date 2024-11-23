import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
       int[] answer = new int[n];

        int div = s/n;


        if(div == 0) {
            answer = new int[]{-1};
        } else {
            int mod = s%n;
            for(int i=0; i<n; i++) {
                answer[i] = div;
            }
            for(int i=0; i<mod; i++) {
                answer[i]++;
            }
            Arrays.sort(answer);
        }

        return answer;
    }
}