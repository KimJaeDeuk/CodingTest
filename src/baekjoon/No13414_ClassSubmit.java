package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No13414_ClassSubmit {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Map<String, Boolean> map = new LinkedHashMap<String,Boolean>();
		for(int i=0; i<L; i++){
			String s = br.readLine();
			if(map.containsKey(s)) {
				map.remove(s);
			
			}
			map.put(s,true);
			
		}
		int cnt=0;
		for(String key : map.keySet()) {
			sb.append(key).append("\n");
			if(++cnt == K)
				break;
			
		}
		System.out.println(sb);
	}

}
