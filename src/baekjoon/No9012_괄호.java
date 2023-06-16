package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9012_괄호 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			
			sb.append(check(line)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static String check(String line) {
		if(line.length()%2==1) {
			return "NO";
		}
		int left=0, right = 0;
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i)=='(') {
				left++;
			}else {
				right++;
			}
			if(right>left) {
				return "NO";
			}
		}
		if(left!=right) return "NO";
		return "YES";
	}

}
