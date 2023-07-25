package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No10_사칙연산 {
	static int N;
	static String tree[];
	static int[][] child;
	static StringBuilder sb = new StringBuilder();
	static Stack<Double> stack;
	static int tc;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/10_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(tc = 1; tc<=10; tc++) {
			stack = new Stack<>();
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			child = new int[N+1][2];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				int n = Integer.parseInt(st.nextToken());
				
				tree[n] = st.nextToken();
				if(tree[n].equals("+")||tree[n].equals("-")||tree[n].equals("/")||tree[n].equals("*")) {
					child[n][0] = Integer.parseInt(st.nextToken());
					child[n][1] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(tc).append(" ");
			preOrder(1);
			double result = stack.pop();
			int intResult = (int)result;
			
			sb.append(intResult);
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

	private static void preOrder(int idx) {
		
		if(idx > N || child[idx][0]==0) {
			stack.push(Double.parseDouble(tree[idx]));
			return;
		}
		
		preOrder(child[idx][0]);
		
		preOrder(child[idx][1]);
		
	
		
		if(tree[idx].equals("+") || tree[idx].equals("/") || tree[idx].equals("*") || tree[idx].equals("-")) {
			doCalc(tree[idx].charAt(0));
		}else {
			stack.push(Double.parseDouble(tree[idx]));
		}
		
	}

	private static void doCalc(char operator) {
		double result = 0;
		
		double num2 = stack.pop();
		double num1 = stack.pop();
		
		if(operator=='+') {
			result = num1 + num2;
		}else if(operator=='/') {
			result = num1 / num2;
		}else if(operator=='-') {
			result = num1 - num2;
		}else if(operator=='*') {
			result = num1 * num2;
		}
		
		stack.push(result);
		
	}

}
