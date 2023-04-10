package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2290_LCDTest {
	static int s = 0;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		
		String n = st.nextToken();
		for(int j=0; j<s; j++) {
			for(int i=0; i<n.length(); i++) {
				if(n.charAt(i)=='1') {
					addOne();
				}else if(n.charAt(i)=='2') {
					
				}else if(n.charAt(i)=='3') {
					
				}else if(n.charAt(i)=='4') {
					
				}else if(n.charAt(i)=='5') {
					
				}else if(n.charAt(i)=='6') {
					
				}else if(n.charAt(i)=='7') {
					
				}else if(n.charAt(i)=='8') {
					
				}else if(n.charAt(i)=='9') {
					
				}else {
					
				}
			}
		}
	}
	private static void addOne() {
		
	}

}
