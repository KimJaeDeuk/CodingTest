package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1476_날짜계산 {
	static int[] arr = new int[3];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i =0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] input = {1,1,1};
		int cnt = 1;
		boolean same = true;
		while(same) {
			boolean wrong = false;
			for(int i=0; i<3; i++) {
				if(input[i] != arr[i]) {
					wrong = true;
					break;
				}
			}
			if(wrong) {
				cnt++;
				for(int i=0; i<3; i++) {
					input[i]++;
					if(i==0 && input[i]>15) {
						input[i] = 1;
					}
					if(i==1 && input[i]>28)
						input[i] = 1;
					if(i==2 && input[i]>19)
						input[i] = 1;
				}
			}else {
				same = false;
			}
		}
		System.out.println(cnt);
	}

}
