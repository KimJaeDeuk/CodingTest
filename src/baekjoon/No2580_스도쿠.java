package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Put{
	int x;
	int y;
	public Put(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class No2580_스도쿠 {
	
	static int sdoku[][] = new int[9][9];
	static ArrayList<Put> list = new ArrayList<Put>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<9;j++) {
				int n = Integer.parseInt(st.nextToken());
				sdoku[i][j] = n;
				if(n==0) list.add(new Put(i,j));
			}
		}
		dfs(0);
		
		
	}
	private static void dfs(int depth) {
		
		if(depth==list.size()) {
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(sdoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		
		Put p = list.get(depth);
			
			for(int i=1; i<=9; i++) {
				if(check(p.x, p.y, i)) {
					sdoku[p.x][p.y] = i; 
					dfs(depth+1);
					sdoku[p.x][p.y] = 0; 
				}
				
			}
			
		
	}
	private static boolean check(int x, int y, int num) {
		
		for(int i=0; i<9; i++) {
			if(sdoku[x][i]==num) return false;
			if(sdoku[i][y]==num) return false;
		}
		
		int startX = (x/3)*3;
		int startY = (y/3)*3;
		
		for(int i=startX; i<startX+3; i++) {
			for(int j=startY; j<startY+3; j++) {
				if(sdoku[i][j]==num) return false;
			}
		}
		
		
		return true;
	}
	
}
