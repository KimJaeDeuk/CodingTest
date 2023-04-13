package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ele{
	int f;
	int cnt;
	public Ele(int f, int cnt){
		this.f = f;
		this.cnt = cnt;
	}
}
public class No5014_스타트링크 {
	static int F, S, G, U, D;
	static Queue<Ele> queue = new LinkedList<Ele>();
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		F = Integer.parseInt(st.nextToken());	//Total 층
		S = Integer.parseInt(st.nextToken());	//강호 위치
		G = Integer.parseInt(st.nextToken());	//스타트링크 위치
		U = Integer.parseInt(st.nextToken());   //up count
		D = Integer.parseInt(st.nextToken());	//down count
		
		visited = new boolean[F+1];
		
		bfs();
	}
	private static void bfs() {
		queue.add(new Ele(S,0));
		visited[S] =true;
		int min = Integer.MAX_VALUE;
		boolean flag = false;
		while(!queue.isEmpty()) {
			Ele e = queue.poll();
			
			int q_floor = e.f;
			int q_cnt = e.cnt;
			if(q_floor == G) {
				flag= true;
				min = Math.min(min, q_cnt);
			}
			if((q_floor-D)>=1 && !visited[q_floor-D]) {
				queue.add(new Ele(q_floor-D,q_cnt+1));
				visited[q_floor-D] = true;
			} 
			if((q_floor+U)<=F && !visited[q_floor+U]) {
				queue.add(new Ele(q_floor+U,q_cnt+1));
				visited[q_floor+U] = true;
			}
		}
		if(flag)
			System.out.println(min);
		else
			System.out.println("use the stairs");
	}

}
