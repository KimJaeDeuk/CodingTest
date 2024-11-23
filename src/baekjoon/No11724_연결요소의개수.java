package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11724_연결요소의개수 {
	static List<Integer>[] arr;
	static int N;
	static int M;
	static int cnt = 0;
	static boolean visited[];
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N =Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		visited = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			if(visited[i]) continue;
			
			bfs(i);
			
		}
		
		if(cnt==0) {
			System.out.println(1);
		} else {
			System.out.println(cnt);
		}
	}

	private static void bfs(int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			List<Integer> list = arr[now];
				
			for(int i=0; i<list.size(); i++) {
				if(!visited[list.get(i)]) {
					queue.add(list.get(i));
					visited[list.get(i)] = true;
				}
			}
			
		}
		cnt++;
	}

}
