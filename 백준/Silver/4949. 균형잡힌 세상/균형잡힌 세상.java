import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		Stack<Character> stack;
		while(!(str = br.readLine()).equals(".")) {
			stack = new Stack<>();
			boolean result = true;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(' || c=='[') {
					stack.push(c);
				} else if(c == ')' || c==']') {
					if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else if(c == ']' && !stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						result = false;
					}
				}
			}
			
			if(!result || stack.size() != 0) {
				sb.append("no");
			} else {
				sb.append("yes");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}