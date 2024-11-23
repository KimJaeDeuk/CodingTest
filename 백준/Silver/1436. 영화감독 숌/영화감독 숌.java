import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int i=0;
		for(i=666; i<=Integer.MAX_VALUE; i++) {
			String num = String.valueOf(i);
			
			if(num.contains("666")) {
				if(++cnt == N) {
					break;
				} 
				
			}
		}
		
		sb.append(i);

		System.out.println(sb);
	}

}