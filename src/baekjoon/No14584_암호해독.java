package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No14584_암호해독 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		char[] encoding = br.readLine().toCharArray();
		
		int n = Integer.parseInt(br.readLine());
		String[] dics = new String[n];
		for(int i=0; i<n; i++) {
			dics[i] = br.readLine();
		}
		
		for(int chIdx=0; chIdx<26; chIdx++) {
			char[] test = encoding.clone();
			
				
			for(int i = 0; i<test.length; i++) {
				test[i] = (char)('a'+(test[i]-'a'+chIdx)%26);
			}
			
			
			for(String dic : dics) {
				String testString = new String(test);
				if(testString.contains(dic)) {
					System.out.println(test);
					System.exit(0);
				}
			}
		}

	}

}
