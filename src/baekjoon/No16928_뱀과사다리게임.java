package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Snake{
	int x;
	int dist;
	Snake(int x,  int dist){
		this.x = x;
		this.dist = dist;
	}
}
public class No16928_뱀과사다리게임 {
	
	static Queue<Snake> que = new LinkedList<Snake>(); 
	static int arr[] = new int[101];
	static boolean visited[] = new boolean[101];
	static int result = Integer.MAX_VALUE;
	static int nx[] = {6,5,4,3,2,1};
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i=1; i<101; i++) {
			arr[i] = i;
		}
		int b = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<b; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		for(int j=0; j<s; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		
		bfs(1);
		System.out.println(result);
	}
	
	private static void bfs(int i) {
		que.add(new Snake(1, 0));
		while(!que.isEmpty()) {
			
			Snake s = que.poll();
			int qx = s.x;
			int qdist = s.dist;
			if(qx==100) {
				result = Math.min(result, qdist); 
				
			}
			for(int k=0; k<6; k++) {
				int dx = nx[k] + qx;
				
				if(dx >100)
					continue;
				
				if(!visited[dx]) {
					visited[dx] = true;
					que.add(new Snake(arr[dx], qdist+1));
				}
			}
			
		}
		
	}
}
