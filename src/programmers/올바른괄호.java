package programmers;

import java.util.Stack;

public class 올바른괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.add(c);
            } else {
            	
                if(stack.size() == 0 || stack.peek()==')') return false; 
                char p = stack.pop();
            }
        }
        if(stack.size() != 0) {
            return false;
        }
        return answer;
    }
}
