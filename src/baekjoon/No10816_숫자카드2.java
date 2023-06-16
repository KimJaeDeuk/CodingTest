package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No10816_숫자카드2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int num=0;
		for(int i=0; i<N; i++) {
			num =Integer.parseInt(st.nextToken());
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				map.put(num, map.get(num) + 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				sb.append(map.get(num)).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
		
	}

}
