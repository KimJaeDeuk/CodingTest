package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class No2164_카드2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new LinkedList<>();	
		
		for(int i=1; i<=size; i++) {
			queue.add(i);
		}
		while(queue.size() != 1) {
			queue.poll();
			
			queue.addLast(queue.pollFirst());
		}
		System.out.println(queue.poll());
	}

}
 