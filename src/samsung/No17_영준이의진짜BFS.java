package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17_영준이의진짜BFS {
	static int N;
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/17_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=test_case; tc++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			
			for(int i=0; i<=N; i++) {
				list.add(new ArrayList<Integer>());
			}
			int tree[][] = new int[N+1][N+1];
			for(int i=2; i<=N; i++) {
				int parent = Integer.parseInt(st.nextToken());
				list.get(parent).add(i);
				tree[parent][i]=1;
				tree[i][parent]=1;
			}
			
			sb.append("#").append(tc).append(" ");
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			int before = -1;
			int cnt = 0;
			while(!q.isEmpty()) {
				int num = q.poll();
				
				if(before != -1) {
					
					cnt += getMinDist(num, before);
					
				}
				
				before = num;
				
				for(int i=0; i<list.get(num).size(); i++) {
					q.add(list.get(num).get(i));
				}
				
			}
			sb.append(cnt);
			//result
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static int getMinDist(int num1, int num2) {
		int dist[] = new int[N];
		int d_i = 1;
		while(num1!=1) {
			
		}
//		if(level[num1] < level[num2]) {
//			
//		}
//		
		return 0;
	}

}
