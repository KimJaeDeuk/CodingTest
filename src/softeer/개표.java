package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 개표 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T =Integer.parseInt(br.readLine());
		
		StringBuilder sb  =new StringBuilder();
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int d = N/5;
			
			int n = N%5;
			
			for(int j=0; j<d; j++) {
				sb.append("++++ ");
			}
			for(int j=0;j<n; j++) {
				sb.append("|");
			}
			
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
