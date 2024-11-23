package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11403_경로찾기 {
	static List<Integer>[] arr;
	static int[][] result;
	static int N;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N];
		
		result = new int[N][N];
		for(int i=0; i<N; i++) {
			arr[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					arr[i].add(j);
					result[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			
			bfs(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int num) {
		List<Integer> node = arr[num];
		boolean visited[] = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.addAll(node);
		
		while(!queue.isEmpty()) {
			
			int path= queue.poll();
			
			List<Integer> nextList = arr[path];
			
			for(int i=0; i<nextList.size(); i++) {
				if(!visited[nextList.get(i)]) {
					queue.add(nextList.get(i));
					result[num][nextList.get(i)] = 1;
					visited[nextList.get(i)] = true;
				}
			}
			
		}
		
	}

}
