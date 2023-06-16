package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class No1874_스택수열 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		int start=0;
		
		while(N-->0) {
			
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {
				
				for(int i=start+1; i<=value; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				start = value;
			}else if(value!=stack.peek()) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-\n");
		}
		
		System.out.println(sb);
	}

}
