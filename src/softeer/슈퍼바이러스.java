package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 슈퍼바이러스 {
	static final int MOD = 1000000007;
	static Long K,P,N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		K = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		N = (Long.parseLong(st.nextToken())*10);
		
		long result = calc(10*N);
		result = (result*K)%MOD;
		System.out.println(result);
	}
	private static long calc(long cnt) {
		if(cnt==1) return P;
		long result = calc(cnt/2);
		
		result = (result*result)%MOD;
		if(cnt%2==1) result = (result*P)%MOD;
		
		return result;
	}

}
