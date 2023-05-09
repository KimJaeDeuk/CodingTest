package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 바이러스 {
	private static long mod = 1000000007;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long K = Long.parseLong(st.nextToken());
		long P = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		
		for(int i=0; i<N; i++) {
			K = (K*P)%mod;
		}
		System.out.println(K);
	}

}
