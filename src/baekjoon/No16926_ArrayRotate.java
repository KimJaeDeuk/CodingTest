package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No16926_ArrayRotate {
	
	static int[][] arr;
	static int N;
	static int M;
	static int R;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int[][] rotate = new int[N][M];
		for(int i=0 ; i<N; i++) {
			arr[i] = Arrays.stream( br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int x=0; x<Math.min(N,M)/2; x++) {
			
				int i=x;
				int j=x;
				
				while((i==x || j==x) || (i==N-x-1 || j==M-x-1)) {
						int cnt=0;
						int newX=i;
						int newY=j;
						while(cnt<R) {
							
							if(newY==x && newX+1 <N-x) {
								newX++;

							}
							else if(newX==N-x-1 && newY+1 <M-x) {
								newY++;
							}
							
							else if(newY==M-x-1 && newX-1>=x) {
								newX--;
							}
							else if(newX==x && newY-1>=x) {
								newY--;
							}
							cnt++;
							
						}
						if(rotate[newX][newY] !=0)
							break;
						rotate[newX][newY] = arr[i][j];
						if(j==x && i+1 <N-x)
							i++;
						else if(i==N-x-1 && j+1 <M-x)
							j++;
						else if(j==M-x-1 && i-1>=x)
							i--;
						else if(i==x && j-1 >=x)
							j--;
					}
				}
				
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(rotate[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
