class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int point = 0;
        int len = w*2+1;

        for(int i=0; i<stations.length; i++) {
            int stationStart = stations[i]-w;
            int stationEnd = stations[i]+w;

            if(stationStart > point) {

                answer += (stationStart-1 - point) % len == 0 ? (stationStart-1 - point)/len : ((stationStart-1 - point)/len )+1;

            }


            point = stationEnd;

        }
        if(n > point) {
            answer += (n- point) % len == 0 ? (n - point) / len : ((n - point) / len) + 1;
        }

        return answer;
    }
}