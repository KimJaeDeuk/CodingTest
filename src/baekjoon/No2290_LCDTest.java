package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2290_LCDTest {
	static int s = 0;
	static StringBuffer sb = new StringBuffer();
	static int[][] lcd = {{0,1,2,4,5,6}, {2,5}, {0,2,3,4} ,{0,2,3,5,6}, {1,2,3,5}, {0,1,3,5,6}, {0,1,3,4,5,6}, {0,2,5}, {0,1,2,3,4,5,6}, {0,1,2,3,5,6}};
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		
		String n = st.nextToken();
		
		for(int i=0; i<n.length(); i++) {
			
		}
	}
	
	

}
