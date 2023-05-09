package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1790_수이어쓰기2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		StringBuffer sb = new StringBuffer();
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long nLength = 0;
		int idx = 1;
		
		while(N>=0) {
			long i = (long) (9*Math.pow(10,idx-1));
			
			if(N-i > 0) {
				N -= i;
				nLength += i;
			}else {
				nLength += N*idx;
				break;
			}
			idx++;
			
		}
		
		if(nLength < K) {
			System.out.println(-1);
			return;
		}
		idx = 1;
		int result = 0;
		long mod=0;
		long div = 0;
		while(K >= 0) {
			long i = (long) (9*Math.pow(10,idx-1))*idx;
			
			if(K-i > 0) {
				K -= i;
			}else {
				result += Math.pow(10, idx-1)- Math.pow(10, idx-2) + K/idx;
				mod = K%idx;
				break;
			}
			
			idx++;
		}
		String r_s = String.valueOf(result);
		System.out.println(r_s.charAt(r_s.length()-1-(int) mod));
	}

}
