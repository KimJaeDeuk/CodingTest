package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No15312_이름궁합 {
	
	public static void main(String[] args) throws Exception{
		int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		String mix = "";
		
		for(int i=0; i<A.length(); i++) {
		
			mix += A.substring(i,i+1)+B.substring(i,i+1);
		}
		int min = mix.length();
		int[] arr = new int[min];
		for(int i=0; i<min; i++) {
			arr[i] = alpha[mix.charAt(i)-'A'];
		}
		int dec = 1;
		while(arr[2]!=-1) {
			
			for(int i=0; i<arr.length-dec; i++) {
				int sum = arr[i]+ arr[i+1];
				arr[i] = sum > 9 ? sum%10 : sum;
			}
			arr[arr.length-dec] = -1; 
			dec++;
		}
		for(int i=0; i<2; i++) {
			System.out.print(arr[i]);
		}
	}

}
