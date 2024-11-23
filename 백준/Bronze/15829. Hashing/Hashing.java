import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		//long before = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		long hash = 0;
		long pow = 1;
		for(int i=0; i<str.length(); i++) {
			
			long num = str.charAt(i)-'a'+1;
			
			num *= pow;
//			num *= (long)Math.pow(31, i);
			pow = (pow*31)%1234567891;
			
			hash += (num%1234567891);
		}
		sb.append(hash%1234567891);
		System.out.println(sb);
		//long after = System.currentTimeMillis();
		
		//System.out.println(after - before);
	}

}