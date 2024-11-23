package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class No1835_카드 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		int cnt = N;
		while(cnt>0) {
			
			queue.addFirst(cnt);
			if(cnt!=N) 
			for(int i=0; i<cnt; i++) {
				queue.addFirst(queue.pollLast());;
			}
			cnt--;
		}
		StringBuilder sb = new StringBuilder();
		queue.forEach(e -> sb.append(e).append(" "));
		System.out.println(sb.toString().trim());
	}

}
