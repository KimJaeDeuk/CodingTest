import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		int hash = 0;
		for(int i=0; i<str.length(); i++) {
			
			int num = str.charAt(i)-'a'+1;
			
			num *= (int)Math.pow(31, i);
			
			hash += num;
			hash %= 1234567891;
		}
		sb.append(hash);
		System.out.println(sb);
	}
}
