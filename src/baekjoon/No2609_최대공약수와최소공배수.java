package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append(gcd(A,B)).append("\n").append(lcm(A,B));
		System.out.println(sb);
	}

	private static int lcm(int a, int b) {
		
		return a*b / gcd(a,b);
	}

	private static int gcd(int a, int b) {
		if(a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

}
