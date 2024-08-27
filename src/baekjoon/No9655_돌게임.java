package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No9655_돌게임 {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 2n 번째 사람은 4n~를 만들어아햠
		// 2n-1 번쨰 사람은 4의배수 ~ 4의배수 +2 를 만들어야함
		
		/*
		 * 		돌 갯수	SK CY
		 * 		1		1		SK
		 * 
		 * 		2		1  1	CY
		 * 		3		3  1	SK
		 * 		4		1  3    CY
		 * 
		 * */
		System.out.println(N%2==1 ? "SK" : "CY");
	}
}
