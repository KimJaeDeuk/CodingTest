import java.util.*;

class Solution {
    public int solution(int[][] routes) {
      int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
//        for(int i=0; i<routes.length; i++) {
//            for(int j=0; j<routes[i].length; j++) {
//                System.out.print(routes[i][j] + " ");
//            }
//            System.out.println();
//        }
        int right= routes[0][1];
        answer++;
        for(int i=1; i<routes.length; i++) {

             if(right < routes[i][0]) {
                answer++;
                right = routes[i][1];
            }else if(right > routes[i][1]) {
                 right = routes[i][1];
             }


        }

        return answer;
    }
}