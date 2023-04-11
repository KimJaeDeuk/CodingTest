package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1013_Contact {

	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			String result = getContact(br.readLine());
			
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static String getContact(String line) {
		
//		int check = 0;
//		for(int i=0; i<line.length(); i++) {
//			int num = line.charAt(i);
//			if(num==0) {
//				if(num) {
//					return "NO";
//				}
//				check = 1;
//			}else {
//				
//			}
//			
//			
//			
//		}
//		
//		return "YES";
		return null;
	}

}
