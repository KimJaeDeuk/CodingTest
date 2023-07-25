package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11_공통조상 {
	static int V, E, o1, o2;
	static int[][] tree;
	static int cnt;
	static boolean find1 = false, find2 = false;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res/11_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=t; tc++) {
			
			//입력 받는 부분
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			o1 = Integer.parseInt(st.nextToken());
			o2 = Integer.parseInt(st.nextToken());
			tree = new int[V+1][2];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<E; i++) {
				int n = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(tree[n][0]!=0)
					tree[n][1] = c; 
				else
					tree[n][0] = c;
			}
			if(tc==1)
			for(int i=1; i<=V; i++) {
				System.out.println( i + "번째 노드 자식들 [ "+ tree[i][0] + " " + tree[i][1] + " ]");
			}
			int subRoot = 0;
			int minCnt = Integer.MAX_VALUE;
			for(int i=1; i<=V; i++) {
				cnt=1;
				dfs(i);
				if(find1 && find2) {
					
					if(minCnt > cnt) {
						minCnt = cnt;
						subRoot = i;
					}
					
				}
				find1 = false;
				find2 = false;
			}
			sb.append("#").append(tc).append(" ");
			
			sb.append(subRoot).append(" ").append(minCnt);
			//알고리즘 부분
			
			sb.append("\n");
			subRoot = 0;
		}
		
		System.out.println(sb);
	}
	private static void dfs(int idx) {
		if(idx==o1) {
			find1 = true;
		}
		
		if(idx==o2) {
			find2 = true;
		}
		
		if(tree[idx][0]==0 && tree[idx][1]==0) {
			return;
		}
		
		
		if(tree[idx][0]!=0) {
			dfs(tree[idx][0]);
			cnt++;
		}
		if(tree[idx][1]!=0) {
			dfs(tree[idx][1]);
			cnt++;
		}
		
		
	}
	

}
