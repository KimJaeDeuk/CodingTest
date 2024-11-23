package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No19638_센티와마법의뿅망치 {
	static PriorityQueue<Long> queue = new PriorityQueue<Long>(Collections.reverseOrder());
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long H = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			Long height = Long.parseLong(br.readLine());
			if(height >=H)
				queue.add(height);
		}
		
		if(queue.size() == 0 ) {
			System.out.println("YES\n"+0);
			return;
		}
		int cnt = 0;
		while(true) {
			cnt++;
			Long height = queue.poll();
			if(height!=1)
				height = height/2;
			
			if(height >= H) {
				queue.add(height);
			}
			
			if(queue.size() == 0 ) {
				System.out.println("YES\n"+cnt);
				break;
			}
			if(T==cnt) {
				System.out.println("NO\n"+queue.poll());
				break;
			}
		}
		
	}

}
