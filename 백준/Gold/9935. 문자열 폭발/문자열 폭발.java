import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Stack<Character> st = new Stack<>();
		String line = br.readLine();
		String bomb = br.readLine();
		
		for(int i=0; i<line.length(); i++) {
			
			st.push(line.charAt(i));
			
			if(st.size()>= bomb.length()) {
				
				boolean flag = false;
				
				for(int j=0; j<bomb.length(); j++) {
					
					if(st.get(st.size() - (bomb.length()-j)) != bomb.charAt(j)) {
						flag = true;
						break;
					}
					
				}
				
				if(!flag) {
					for(int j=0; j<bomb.length(); j++) {
						st.pop();
					}
				}
			}
			
		}
		if(st.size() == 0 ) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			
			while(!st.isEmpty()) {
				sb.append(st.pop());
			}
//			sb.reverse();
			System.out.println(sb.reverse());
		}
		
		
		// mirkovC4  	stack.size == 8
		//				stack.get(6 ~ 7)
		// C4
	}
	
}