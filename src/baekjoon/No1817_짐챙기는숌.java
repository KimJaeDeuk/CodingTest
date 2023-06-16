package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1817_짐챙기는숌 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		
		int cnt = 1;
		int weight = 0;
		for(int i=0; i<N; i++) {
			weight += list.get(i);
			if(weight>M) {
				weight = list.get(i);
				cnt++;
			}
		}
		
		
			sb.append(cnt);
		
		
		System.out.println(sb);
	}

}
