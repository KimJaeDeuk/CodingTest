package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260_DFS와BFS {
	static int D, N, start;
	static int[][] arr;
	static boolean[] visited;
	static LinkedList<Integer>[] graph;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		arr = new int[D+1][D+1];
		visited = new boolean[D+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(start);
		System.out.println();
		visited = new boolean[D+1];
		bfs();
		
	}
	private static void dfs(int point) {
		visited[point] = true;
		System.out.print(point+" ");
		for(int i=1; i<=D; i++) {
			if(arr[point][i]==1&& !visited[i] ) {		
				dfs(i);
			}
			
		}
		
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int a = q.poll();
			System.out.print(a+" ");
			for(int i=1; i<D+1; i++) {
				if(!visited[i] && arr[a][i] ==1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}

}
