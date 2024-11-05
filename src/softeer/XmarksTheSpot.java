package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XmarksTheSpot {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int idx = st.nextToken().toLowerCase().indexOf('x');
			String str2 = st.nextToken().toUpperCase();
			result.append(str2.charAt(idx));
			
		}
		
		System.out.println(result);

	}

}
