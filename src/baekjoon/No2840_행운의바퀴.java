package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2840_행운의바퀴 {
	static int N, K;
	static String[] arr;
	static int idx=0;
	static boolean[] alpha = new boolean[26];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new String[N];
		
		for(int i=0; i<K; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			rotate(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int i=idx; i<N+idx; i++) {
			String rs = arr[i%N]==null ? "?" : arr[i%N];
			sb.append(rs);
		}
		System.out.println(sb);
	}
	private static void rotate(int rotateCnt, String str) {
		
		idx = (N+idx- rotateCnt%N)%N;
		
		if(arr[idx]!= null && !str.equals(arr[idx])) {
			System.out.println("!");
			System.exit(0);
		}else if(arr[idx]==null){
			if(!alpha[str.charAt(0)-'A']) {
				arr[idx] = str;
				alpha[str.charAt(0)-'A'] = true;
			}else {
				System.out.println("!");
				System.exit(0);
			}
		}
		
	}

}
