package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No27964_콰트로치즈피자 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> cheeseSet = new HashSet<>();
		for(int i=0; i<N; i++) {
			String cheese = st.nextToken();
			
			if(cheese.endsWith("Cheese")) {
				cheeseSet.add(cheese);
			}
		}
		
		if(cheeseSet.size()>=4) {
			System.out.println("yummy");
		}else {
			System.out.println("sad");
		}

	}

}
