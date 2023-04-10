package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1759_암호만들기 {

	static char[] arr;
	static char code[];
	static int L;
	static int C;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		code = new char[L];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			
			arr[i] = st.nextToken().charAt(0);
			
		}
		
		Arrays.sort(arr);
		
		dfs(0,0); 
	}
	private static void dfs(int cnt, int start) {
		
		if(L==cnt) {
			if(check(code)) {
				for(char c : code) 
					System.out.print(c);
				System.out.println();
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			code[cnt] = arr[i];
			
			dfs(cnt+1, i+1);
		}
		
	}
	private static boolean check(char[] code) {
		int mo = 0;
		int ja = 0;
		
		for(int i=0; i<code.length; i++) {
			
				if(code[i]=='a'||code[i]=='e'||code[i]=='i'||code[i]=='o'||code[i]=='u') {
					mo++;
				}else {
					ja++;
				}
				
			
		}
		if(mo>=1 && ja>=2)
			return true;
		
		return false;
	}

}
