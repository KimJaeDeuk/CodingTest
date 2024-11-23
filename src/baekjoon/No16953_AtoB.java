package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16953_AtoB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		Queue<long []> queue = new LinkedList<>();
		
		boolean visited[] = new boolean[(int)B+1];
		
		visited[(int)A] = true;
		queue.add(new long[] {A,0});
		int result = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			long[] arr = queue.poll();
			
			if(arr[0] == B) {
				result = Math.min(result, (int)arr[1]);
			}
			
			if(arr[0]*2 <= B && !visited[(int)(arr[0]*2)]) {
				visited[(int)(arr[0]*2)] = true;
				queue.add(new long[] {arr[0]*2, arr[1]+1});
			}
			long plusOne = Long.parseLong(String.valueOf(arr[0]) + "1");
			
			if( plusOne <=B&& !visited[(int)plusOne]) {
				visited[(int)plusOne] = true;
				queue.add(new long[] {plusOne, arr[1] +1});
			}
			
		}
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result+1);
		}
		br.close();

	}

}
