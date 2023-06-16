package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1715_카드정렬하기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}
		
		long result = 0;
		
		
		while(queue.size()!=1) {
			int sum = queue.poll() + queue.poll();
			
			result += sum;
			
			queue.add(sum);
			
		}
		System.out.println(result);
	}

}
