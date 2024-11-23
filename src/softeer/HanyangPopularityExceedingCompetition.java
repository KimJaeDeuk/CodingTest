package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HanyangPopularityExceedingCompetition {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int popular = 0;
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(Math.abs(p-popular) <= c) {
				popular++;
			}
		}
		System.out.println(popular);

	}

}
