import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static long A,B,C;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		
		System.out.println(dfs(B));
		
	}
	private static long dfs(long exponent) {
		
		if(exponent == 1) {
			
			return A % C;
			
		}
		// 지수가 1/2 인 값을 구하기
		long tmp = dfs(exponent/2);
		
		if(exponent %2 == 1) {
			return ((tmp * tmp %C) *A )%C;
			/* 
			 * 여기는 홀수이므로 tmp * tmp * A가 되어야함
			 * // (a * b) % C = ((a % C)*(b % C)) % C
			(temp * temp * A) % C = ((temp * temp % C) * (A % C)) % C
								  = (((temp * temp % C) % C) * (A % C)) % C  // (temp * temp % C) = (temp * temp % C) % C
								  = ((temp * temp % C) * A) % C
			 */
			
		}
		
		return ((tmp%C) * (tmp%C))%C;
		
	}
}
