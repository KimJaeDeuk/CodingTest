package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class No2824_최대공약수 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		BigInteger nSum = new BigInteger("1");
		BigInteger mSum = new BigInteger("1");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			nSum = nSum.multiply( new BigInteger(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++) {
			mSum = mSum.multiply(new BigInteger(st.nextToken()));
		}
		
		String a = String.valueOf(nSum.gcd(mSum));
		if(a.length()>9)
			System.out.println(a.substring(a.length()-9, a.length()));
		else
			System.out.println(a);
	}
	

}
