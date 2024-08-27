import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static long arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Long> set = new HashSet<Long>();
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			set.add(arr[i]);
		}
		
		ArrayList<Long> list = new ArrayList<>(set);
		
		Collections.sort(list);
		
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		for(int i=0; i<list.size(); i++) {
			map.put(list.get(i), i);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
	
}
