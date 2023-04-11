package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1107_리모컨 {
	static int now = 100;
	static int N;
	static String stringN;
	static int M;
	static boolean[] error;
	static int result = 999999;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		error = new boolean[10];
		stringN = String.valueOf(N);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			error[Integer.parseInt(st.nextToken())] = true; 
		}
		getMin();
	}
	private static void getMin() {
		
		int result = Math.abs(N-100); // 100부터 시작하니 초기값 설정 *음수처리*
		for(int i=0; i<999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			boolean stop = false;
			for(int j=0; j<len; j++) {	//각 length를 돌며 error가 true인 곳을 만나면 연산을 하지 않고 break
				if(error[str.charAt(j)-'0']) {
					stop = true;
					break;
				}
			}
			
			if(!stop) {	//연산 수행 유무
				
				int min = Math.abs(N - i) + len; // +, - 터치에 따른 Math.abs(N-i), 번호를 누를 len	
				
				result = Math.min(min, result);
				
			}
		}
		System.out.println(result);
				
	}

}
