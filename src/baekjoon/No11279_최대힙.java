package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class No11279_최대힙 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb  =new StringBuilder();
		for(int i=0; i<N; i++) {
			
			int input = Integer.parseInt(br.readLine());
			
			if(input==0) {
				if(queue.isEmpty()) {
					sb.append(0);
				}else {
					sb.append(queue.poll());
				}
				sb.append("\n");
			}else {
				queue.add(input);
			}
		
		}
		System.out.println(sb);

	}

}
