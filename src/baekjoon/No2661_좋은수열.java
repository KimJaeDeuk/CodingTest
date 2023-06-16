package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2661_좋은수열 {
	static int n;
	static String max = "";
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dfs("");
		System.out.println(max + "  " + max.length());
	}
	private static void dfs(String sb) {
		if(max!= "") return;
		if(sb.length()==n) {
			
			
				max = sb;
			return; 
		}
		
		for(int i=1; i<=3; i++) {
		
			if(check(sb+i))
				dfs(sb+i);
			
		}
	}
	private static boolean check(String value) {
		
		for(int i=1;i<=value.length()/2;i++) {
			for(int j=0;j<=value.length()-i*2;j++) {
				if(value.substring(j,j+i).equals(value.substring(j+i,j+i*2))) return false;
			}
		}
		return true;
	}

}
