package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진정한효도 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[3][3];
		StringTokenizer st;
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 가로
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			int sum = 10;
			for(int x=1; x<=3; x++) {
				int numMin = 0;
				int numMin2 = 0;
				for(int j=0; j<3; j++) {
					
					
					numMin += Math.abs(x - arr[i][j]);
					numMin2 += Math.abs(x - arr[j][i]);
					
					
				}
				sum = Math.min(sum, Math.min(numMin2,numMin));
			}
			min = Math.min(sum, min);
		}
		
		System.out.println(min);
		
	}

}
