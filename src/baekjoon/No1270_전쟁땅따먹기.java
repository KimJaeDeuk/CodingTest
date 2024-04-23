package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1270_전쟁땅따먹기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int t = Integer.parseInt(st.nextToken());
			HashMap<Long, Integer> army = new HashMap<>();
			for(int j=0; j<t; j++) {
				long num = Long.parseLong(st.nextToken());
				
				if(!army.containsKey(num)) {
					army.put(num, 1);
				} else {
					army.put(num, army.get(num) +1);
				}
				
			}
			
			boolean isTrue = false;
			for(long num : army.keySet()) {
				if(army.get(num) > t/2) {
					isTrue = true;
					sb.append(num).append("\n");
					break;
				}
			}
			if(!isTrue) {
				sb.append("SYJKGW").append("\n");
			}
		}
		System.out.println(sb);
	}

}
