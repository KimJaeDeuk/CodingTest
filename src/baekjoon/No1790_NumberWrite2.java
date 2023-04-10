package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1790_NumberWrite2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int nLength = 0;
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			
			if(N/Math.pow(10, i) <10) {
				nLength += ( N-Math.pow(10, i)+1 )*(i+1);
				break;
			}
			
			nLength += (i+1)* Math.pow(10, i)*9;
		}
		if(nLength < K) {
			sb.append(-1);
			
		}else {
			int idx=0;
			while(true) {
				if(K-Math.pow(10, idx) * (idx+1) * 9 <=0) {
					idx++;
					break;
				}
				K -= Math.pow(10, idx) * (idx+1) * 9;
				idx++;
			}
			int mok = K/idx -1;
			int namuji = (K-1)%idx;
			System.out.println(K);
			System.out.println(idx);
			System.out.println(mok);
			ans = (int) (Math.pow(10,idx-1) ) + mok;

			System.out.println(ans);
			String s = String.valueOf(ans);
			sb.append(s.charAt(namuji));
			
			
		}
		System.out.println(sb);
	}

}
