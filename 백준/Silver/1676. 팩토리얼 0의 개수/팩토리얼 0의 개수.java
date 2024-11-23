import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(br.readLine());
		if(N==0 || N == 1) {
			System.out.println(0);
			return;
		} 
		long fact[] = new long[N+1];
		fact[1] = 1;
		int cnt = 0;
		
		for(int i=2; i<=N; i++) {
			fact[i] = fact[i-1]*i;
			for(;;) {
				if(fact[i] % 10 == 0) {
					cnt++;
					fact[i] = fact[i] / 10;
				} else {
					break;
				}
			}
			fact[i] = fact[i] % 1000;
		}
		
		sb.append(cnt);
		
		System.out.println(sb);
	}

}