package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_8단변속기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr=  new int[8];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean increase = true; 
		boolean decrease = true;
		
		for(int i=1; i<8; i++) {
			if(arr[i-1] < arr[i]) {
				decrease = false;
			} else if (arr[i-1] > arr[i]){
				increase = false;
			}
		}
		
		if(increase) {
			System.out.println("ascending");
		} else if(decrease) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		
	}

}
