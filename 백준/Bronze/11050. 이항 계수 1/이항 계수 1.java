import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
//		
//		int[] factorial = new int[N+1];
//		factorial[1] = 1;
//		for(int i=2; i<=N; i++) {
//			factorial[i] = factorial[i-1]*i;
//		}
//		
		sb.append(facto(N) / (facto(N-K)* facto(K)));
		
		System.out.println(sb);
	}



	private static int facto(int n2) {
		if(n2 == 0) {
			return 1;
		}
		return n2 * facto(n2-1);
	}
	
}
