package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No26215_눈치우기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			
			queue.add(Integer.parseInt(st.nextToken()));
			if(queue.peek()>1440) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		int total = 0;
		while(!queue.isEmpty()) {
			int max = queue.poll();
			int second_max = 0;
			if(!queue.isEmpty()) {
				second_max = queue.poll();
			}
			
			if(second_max==0) {
				total += max;
				break;
			}else {
				total += second_max;
			}
			if(max-second_max >0) {
				queue.add(max - second_max);
			}
			
		}
		
		if(total >1440) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(total);
	}

}
