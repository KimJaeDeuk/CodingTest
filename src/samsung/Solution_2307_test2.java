package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos{
	int n;
	int value;
	public Pos(int n, int value){
		this.n = n; 
		this.value = value;
	}
}
public class Solution_2307_test2 {
	static int N, M, Q;
	static int[][] arr;
	static boolean check;
	static Pos rowMax[], colMax[];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TestCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		for(int tc=1; tc<=TestCase; tc++) {
			int sum=0;
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			
			check = N < M ? true : false;
			
			rowMax = new Pos[N+1];
			colMax = new Pos[M+1];
			
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int rowy =0;
				int rowNum =0;
				for(int j=1; j<=M; j++) {
					int num = Integer.parseInt(st.nextToken());
					
					colMax[j] = colMax[j] == null || colMax[j].value < num ? new Pos(i,num) : colMax[j];
					
					if(rowNum < num) {
						rowNum = num;
						rowy = j;
					}
				}
				
				rowMax[i] = new Pos(rowy, rowNum);
				
			}
			
			int r, c, x;
			for(int i=0; i<Q; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				
				change(rowMax, colMax, r,c,x);
				
				sum += getCnt(rowMax, colMax);
				
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			
		}
		System.out.println(sb);
	}
	private static void change(Pos[] rowMax, Pos[] colMax, int r, int c, int x) {
		
		if(rowMax[r].value < x) 
			rowMax[r] = new Pos(c,x);
			
		if(colMax[c].value < x) 
			colMax[c] = new Pos(r,x);
				
	}
	private static int getCnt(Pos[] rowMax, Pos[] colMax) {
		int cnt=0;
		
		if(check) {	// M 이 작을경우
			
			for(int i=1; i<=N; i++) {
				Pos p = rowMax[i];
				
				if(p.value > colMax[p.n].value || i == colMax[p.n].n) {
					cnt++;
				}
				
			}
			
		}else { // N이 작을경우
			for(int i=1; i<=M; i++) {
				Pos p = colMax[i];
				
				if(p.value > rowMax[p.n].value || i == rowMax[p.n].n) {
					cnt++;
				}
				
			}
			
			
		}
		
		return cnt;
	}

}
