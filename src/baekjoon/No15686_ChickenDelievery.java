package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Chicken{
	int x;
	int y;
	public Chicken(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class House{
	int x;
	int y;
	public House(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class No15686_ChickenDelievery {
	
	static int N,M;
	static ArrayList<House> list = new ArrayList<House>();
	static ArrayList<Chicken> chicken = new ArrayList<Chicken>();
	static int[][] arr;
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					list.add(new House(i,j));
				}else if(num==2) {
					chicken.add(new Chicken(i,j));
				}
			}
		}
		visited = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.println(min);
	}

	private static void dfs(int depth, int start) {
		
		if(depth>=M) {
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			
			if(!visited[i]) {
				visited[i] = true;
				getDistance();
				dfs(depth+1, i+1);
				
				visited[i] = false;
				
			}
			
		}
		
	}

	private static void getDistance() {
		int sum = 0;
		for(boolean a : visited)
			if(a) System.out.print(1+" ");
			else System.out.print(0+" ");
		System.out.println();
		for(int i=0; i<list.size(); i++) {
			House h = list.get(i);
			int dist = Integer.MAX_VALUE;
			for(int j=0; j<visited.length; j++) {
				if(visited[j]) {
					dist =Math.min(Math.abs(chicken.get(j).x - h.x) + Math.abs(chicken.get(j).y - h.y), dist);

				}
			}
			
			sum += dist;
		}
		min = Math.min(sum, min);
		
	}

}
