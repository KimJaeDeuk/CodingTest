package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No22233_가희와키워드 {
	static int N,M;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
//		ArrayList<String> list = new ArrayList<>();
		HashMap<String, Boolean> keyWords = new HashMap<>(); 
		for(int i=0; i<N; i++) {
			keyWords.put(br.readLine(), false);
			//list.add(br.readLine());
		}
		
		int result = N;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String[] arr = br.readLine().split(",");
			
			for(String s : arr) {
				
				if(keyWords.containsKey(s) && !keyWords.get(s)) {
					keyWords.put(s, true);
					result--;
				}
			}
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
