package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1251_WordDivision {
	static String s;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		String max = "zzzzzzzzz";
		String result="";
		for(int i=0; i<s.length()-2; i++) {
			for(int j=i+1; j<s.length()-1; j++) {
				
				result = reverse(i,j);
				if(result.compareTo(max) < 0 )
					max = result;
			}
		}
		
		System.out.println(max);
	}
	private static String reverse(int i, int j) {
		String reverse = "";
		for(int a = i; a>= 0 ; a--)
			reverse += s.charAt(a);
		for(int a = j; a>= i+1; a--)
			reverse += s.charAt(a);
		for(int a = s.length()-1; a>=j+1 ;a--)
			reverse += s.charAt(a);
		
		return reverse;
	}

}
