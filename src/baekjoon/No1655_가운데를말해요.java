package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class No1655_가운데를말해요 {
	static PriorityQueue<Integer> list = new PriorityQueue<>();
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for(int i=0; i<N; i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			
			sb.append(getMiddle(num)).append("\n");
			
			
		}
		System.out.println(sb);

	}
	private static int getMiddle(int num) {
		list.add(num);
		int idx = list.size()%2==0 ? list.size()/2-1 : list.size()/2;
		int cnt = 0;
		int a = 0;
		for(Integer i : list) {
			if(cnt==idx) {
				a = i;
				break;
			}
			cnt++;
			
		}
		return a;
	}

}
