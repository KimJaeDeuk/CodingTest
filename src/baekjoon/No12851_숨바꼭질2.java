package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Qclass{
	int order;
	int sec;
	public Qclass(int a, int sec) {
		this.order = a;
		this.sec = sec;
	}
}

public class No12851_숨바꼭질2 {
	static Queue<Qclass> queue = new LinkedList<Qclass>();
	static int min = 1000000;
	static int dong;
	static int result = 0;
	static boolean visited[] = new boolean[100001];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int su = Integer.parseInt(st.nextToken());
		dong = Integer.parseInt(st.nextToken());
		queue.add(new Qclass(su, 0));
		visited[su] = true;
		if(su==dong) {
			System.out.println(0+"\n"+1);
			return;
		}
		bfs();
	}
	private static void bfs() {
		
		while(!queue.isEmpty()) {
			Qclass q = queue.poll();
			
			int su = q.order;
			int sec = q.sec;
			
			for(int i=-1; i<=1; i++) {
				int move;
				if(i==0) {
					move = su*2;
				}else {
					move = su+=i;
				}
				
				if(i<0 || i>100000) continue;
				
				if(move==dong) {
					result++;
					min = sec;
					
				}
				
				
			}
			
		}
		
	}

}
