package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2이진수표현 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		for(int i=1; i<=testCase; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			
			String result = getResult(N, M);
			
			sb.append("#"+i+ " "+result).append("\n");
		}
		System.out.println(sb);
	}

	private static String getResult(int n, long m) {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<n; i++) {
			
			if(m%2==0) {
				return "OFF";
			}
			m /= 2;
		}
		
		
		return "ON";
	}

}
