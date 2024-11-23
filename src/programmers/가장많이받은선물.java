package programmers;

import java.util.Arrays;
import java.util.List;

public class 가장많이받은선물 {

	public static void main(String[] args) {
		String friends[] = {"joy", "brad", "alessandro", "conan", "david"};
		String gifts[] = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
		System.out.println(solution(friends, gifts));
		
		
	}

	private static int solution(String[] friends, String[] gifts) {
int answer = getResult(friends, gifts);
        
        return answer;
	}

	private static int getResult(String[] friends, String[] gifts) {
		List<String> friend_list = Arrays.asList(friends);
        int f_len = friends.length;
        int [][]arr = new int[f_len][f_len+2];
        for(String g : gifts) {
            String[] split = g.split(" ");
            int give = friend_list.indexOf(split[0]);
            int receive = friend_list.indexOf(split[1]);
            arr[give][receive]++;
            arr[give][f_len]++;
            arr[receive][f_len+1] ++;
        }
        
        int result[] = new int[f_len];
        for(int i=0; i<f_len; i++){
            for(int j=i; j<f_len; j++){
                if(i==j) continue;
                if(arr[i][j] == arr[j][i]) {
                	
                    if((arr[i][f_len] - arr[i][f_len+1]) == (arr[j][f_len] - arr[j][f_len+1])) {
                        continue;
                    } else {
                        if(arr[i][f_len] - arr[i][f_len+1] > arr[j][f_len] - arr[j][f_len+1]) {
                            result[i]++;
                        } else {
                            result[j]++;
                        }
                    }
                } else {
                    if(arr[i][j] > arr[j][i]) {
                        result[i]++;
                    } else if (arr[i][j] < arr[j][i]){
                        result[j]++;
                    }
                }
            }
        }
        Arrays.sort(result);
        return result[f_len-1];
	}

}
