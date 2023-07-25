package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class No9_사칙연산유효성검사 {
	static int N;
	static ArrayList<ArrayList<String>> tree;
	static String[] value;
	static StringBuilder sb = new StringBuilder();
	static boolean possible;
	static int a=0;
	static ArrayList<Character> list = new ArrayList<Character>();
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res/9_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list.add('+');
		list.add('/');
		list.add('*');
		list.add('-');
		for(int tc = 1; tc <= 10; tc++) {
			
			N = Integer.parseInt(br.readLine());
			tree = new ArrayList<ArrayList<String>>();
			
			value = new String[N+1];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(st.nextToken());
				String calc = st.nextToken();
				if(calc.equals("+") || calc.equals("-") || calc.equals("/") || calc.equals("*")) {
					value[n] = calc;
					
				}else  {
					int num = Integer.parseInt(calc);
					
				}
				
			}
			
			sb.append("#").append(tc).append(" ");
			possible = true;
			a=0;
			
			inOrder(1);
			
			
			sb.append(possible ? 1 : 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	private static void inOrder(int idx) {
		
		
		
	}

}
