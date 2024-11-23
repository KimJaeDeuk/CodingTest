import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int N, total;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb  =new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- >0) {
			N = Integer.parseInt(br.readLine());
			total = 1;
			map = new HashMap<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 0) + 1);
				
			}
			
			for(String key : map.keySet()) {
				total *= (map.get(key)+1);
			}
			
			sb.append(total-1).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
