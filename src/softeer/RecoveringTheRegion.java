package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RecoveringTheRegion {
	
	static class Pos{
		int x;
		int y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] result;
	static int[][] sdoku;
	static int[] nx = {0,0,-1,1};
	static int[] ny = {1,-1,0,0};
	static int N;
	static boolean[][] visited;
	static ArrayList<Pos> visitedList;
	
	public static void main(String[] args) throws Exception{
		init();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(i +" ");
			}
			System.out.println();
		}
//		dfs(0);
	}

	private static void dfs(int areaCnt) {
		
		if(areaCnt == N) {
			printResult();
			System.exit(0);
		}
		
		for(int a=0; a<N; a++) {
			for(int b=0; b<N; b++) {
				
				if(!visited[a][b]) {
					visitedList = bfs(a,b);
					
					if(visitedList.size()==N) {
						// 방문한곳이 6곳이라는뜻이므로 전체 구역을 다 돎
						// 성공했으면 다시 한번 더 dfs 굴리기
//						resultMap.put(areaCnt+1, visitedList);
						for(Pos p : visitedList) {
							visited[p.x][p.y] = true; 
							result[p.x][p.y] = areaCnt+1; 
						}
						dfs(areaCnt+1);
						
					}
					for(Pos p : visitedList) {
						visited[p.x][p.y] = false; 
					}
				}
				
			}
			
		}
		
	}



	private static ArrayList<Pos> bfs(int i, int j) {
		ArrayList<Pos> list = new ArrayList<>();
		Queue<Pos> queue = new LinkedList<>();
		Pos init = new Pos(i,j);
		list.add(new Pos(i,j));
		queue.add(init);
		
		boolean[] numVisit = new boolean[N+1];
		numVisit[sdoku[i][j]] = true;
		while(!queue.isEmpty()) {
			
			Pos p = queue.poll();
			
			for(int k=0; k<4; k++) {
				int dx = nx[k] + p.x;
				int dy = ny[k] + p.y;
				
				if(dx < 0 || dx >=N || dy<0 || dy>=N || visited[dx][dy] || numVisit[sdoku[dx][dy]]) {
					continue;
				}
				numVisit[sdoku[dx][dy]] = true;
				Pos next = new Pos(dx,dy);
				list.add(new Pos(dx, dy));
				
				queue.add(next);
				
			}
		}
		
		return list;
	}



	private static void printResult() {
		StringBuilder sb = new StringBuilder();
//		for(Integer key : resultMap.keySet()) {
//			ArrayList<Pos> list = resultMap.get(key);
//			
//			for(Pos p : list) {
//				result[p.x][p.y]= key; 
//			}
//		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		result = new int[N][N];
		sdoku = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				sdoku[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
	}

}
