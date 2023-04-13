package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Chonsu{
	int y;
	int cost;
	public Chonsu(int y, int cost) {
		
		this.y = y;
		this.cost = cost;
	}
}

public class No2644_촌수계산 {
	static int N;
	static int[][] arr;
	static int first, last;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		first = Integer.parseInt(st.nextToken());
		last = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		int min = bfs();
		System.out.println(min);
	}
	private static int bfs() {
		
		Queue<Chonsu> list = new LinkedList<Chonsu>();
		for(int i=1; i<N+1; i++)
			if(arr[first][i]!=0) {
				list.add(new Chonsu(i,1));
				visited[first][i] = true;
			}
		while(!list.isEmpty()) {
			Chonsu q = list.poll();
			int a = q.y;
			int cost = q.cost;
			for(int i=1; i<N+1; i++) {
				if(arr[a][i]!=0 && !visited[a][i]) {
					visited[a][i] = true;
					if(i==last) return cost+1;
					list.add(new Chonsu(i, cost+1));
				}
			}
		}
		return -1;
	}

}
