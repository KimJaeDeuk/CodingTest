package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No16924_십자가찾기 {
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		char arr[][] = new char[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<int[]> result = new ArrayList<int[]>();
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<M; j++) {
				
				if(arr[i][j]!='.') {
					int cnt=0;
					int size=0;
					while(true) {
						cnt = 0;
						size++;
						for(int k=0; k<4; k++) {
							int nx = dx[k]*size + i;
							int ny = dy[k]*size + j;
							
							if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny]!='.') {
								cnt++;
							}else {
								break;
							}
							
						}
						if(cnt==4) {
							for(int k=0; k<4; k++) {
								int nx = dx[k]*size + i;
								int ny = dy[k]*size + j;
								arr[nx][ny] = '#';
							}
							arr[i][j] = '#';
							result.add(new int[] {i+1,j+1,size});
						}else {
							break;
						}
					}
					
				}
				
			}
			
		}
		if(check(arr)) {
			sb.append(-1);
			
		}else {
			sb.append(result.size()).append("\n");
			for(int[] ar : result) {
				sb.append(ar[0]).append(" ").append(ar[1]).append(" ").append(ar[2]).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	private static boolean check(char[][] arr) {
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]=='*') {
					return true;
				}
			}
		}
		return false;
	}

}
