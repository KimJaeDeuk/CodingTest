package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Subject{
	int score;
	int spent;
	
	Subject(int score, int spent){
		this.score = score;
		this.spent = spent;
	}
}

public class No17952_과제는끝나지않아 {
	
	static Stack<Subject> stack = new Stack<Subject>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int total = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sub = Integer.parseInt(st.nextToken());
			
			if(sub==1) {
				int score = Integer.parseInt(st.nextToken());
				int spent = Integer.parseInt(st.nextToken());
				stack.push(new Subject(score,spent));
				
			}
			if(!stack.isEmpty()) {
				Subject s = stack.peek();
				s.spent--;
				
				if(s.spent==0) {
					total += s.score;
					stack.pop();
				}
			}
		}
		System.out.println(total);
		
	}

}
