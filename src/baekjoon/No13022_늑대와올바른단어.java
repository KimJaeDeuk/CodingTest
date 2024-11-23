package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No13022_늑대와올바른단어 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		char arr[] = {'o','l','f'};
		int cnt = 0;
		int idx = 0;
		Stack<Integer> s = new Stack<>();
		
		int cnt_arr[] = new int[4];
		for(int i=0; i<line.length(); i++) {
			char c = line.charAt(i);
			
			if(c=='w') {
				cnt_arr = new int[4];
				cnt++;
				idx = 0;
			} else {
				cnt_arr[0] = cnt;
				if(c==arr[idx]) {
					cnt_arr[idx+1]++;
					if(cnt_arr[idx+1]==cnt) {
						idx++;
					}
				} else {
					System.out.println(0);
					System.exit(0);
				}
			}
			
		}
		System.out.println(1);
		
	}

}
