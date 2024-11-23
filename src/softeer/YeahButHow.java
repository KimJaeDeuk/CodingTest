package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class YeahButHow {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i]=='(') {
				if(!stack.isEmpty() && stack.peek() == ')') {
					queue.add('+');
				}
					stack.add('(');
					queue.add('(');
				
			} else {
				if(!stack.isEmpty() && stack.peek() == '(') {
					queue.add('1');
				}
				stack.add(')');
				queue.add(')');
			}
			
		}
		while(!queue.isEmpty()) sb.append(queue.poll());
		
		System.out.println(sb);

	}

}
