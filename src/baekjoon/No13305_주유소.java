package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13305_주유소 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int city = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] distArr = new long[city-1];
		for(int i=0; i<city-1; i++) {
			distArr[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		long[] oil = new long[city];
		for(int i=0; i<city; i++) {
			oil[i] = Long.parseLong(st.nextToken());
		}
		long price = oil[0];
		int idx = 1;
		while(price < oil[idx]) {
			idx++;
			if(idx==city) {
				idx--;
				break;
			}
		}
		long result = 0;
		
		for(int i=0; i<city-1; i++) {
			long dist = distArr[i];
			
			if(idx == i) {
				price = oil[i];
				idx = i+1;
				while(price < oil[idx]) {
					idx++;
					if(idx==city) {
						idx--;
						break;
					}
				}
			}
			
			result += dist*price;
			
		}
		System.out.println(result);
	}

}
