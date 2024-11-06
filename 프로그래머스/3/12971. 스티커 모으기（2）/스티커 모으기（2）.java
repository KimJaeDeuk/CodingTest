class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int[] odd = new int[sticker.length];
        int[] even = new int[sticker.length];
        odd[0] = sticker[0];
        for(int i=0; i<sticker.length-1; i++) {
            int lenTwo = (i-2);
            int lenThree = (i-3);

            if(lenTwo >=0) {
                odd[i] = Math.max(odd[lenTwo] + sticker[i], odd[i]);
            }
            if(lenThree >=0) {
                odd[i] = Math.max(odd[lenThree] + sticker[i], odd[i]);
            }
            if(lenTwo <0 && lenThree <0) {
                odd[i] = sticker[i];
            }
        }

        for(int i=1; i<sticker.length; i++) {
            int lenTwo = (i-2);
            int lenThree = (i-3);

            if(lenTwo >=0) {
                even[i] = Math.max(even[lenTwo] + sticker[i], even[i]);
            }
            if(lenThree >=0) {
                even[i] = Math.max(even[lenThree] + sticker[i], even[i]);
            }
            if(lenTwo <0 && lenThree <0) {
                even[i] = sticker[i];
            }
        }
        for(int i=0; i<sticker.length; i++) {
            answer = Math.max(Math.max(odd[i], even[i]), answer);
        }

        return answer;
    }
}