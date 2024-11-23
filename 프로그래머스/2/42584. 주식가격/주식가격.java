class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length-1; i++) {
            int j=i+1;
            boolean isDown = false;
            for(; j<prices.length; j++) {
                if(prices[i] > prices[j]) {
                    isDown = true;
                    break;
                }
            }
            if(isDown) {
                answer[i] = j-i;    
            } else {
                answer[i] = prices.length - (i+1);
                
            }
            
        }
        
        return answer;
    }
}