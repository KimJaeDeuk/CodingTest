import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;
        int bPoint = len-1;
        for(int i=len-1; i>=0; i--) {

            if(A[i] < B[bPoint]) {
                answer++;
                bPoint--;
            }
        }


        return answer;
    }
}