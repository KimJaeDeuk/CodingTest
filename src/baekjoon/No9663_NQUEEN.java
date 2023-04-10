package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No9663_NQUEEN {
static int arr[][];
static int result = 0;
static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		int cnt = N;
		
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dfs(i,j, 0);
			}
			arr = new int[N][N];
		}
		System.out.println(result);
	}

	private static void dfs(int i, int j, int cnt) {
		
		if(cnt == N) {
			result++;
			return;
		}
		else {
			for(int n = 0; n<N ;n++) {
				arr[i][n] += 1;
				arr[n][j] += 1;
				
			}
			
			int idx = 0;
			while(i-idx >=0 && j-idx >=0) {
				arr[i-idx][j-idx] += 1;
				idx++;
			}
			
			idx = 0;
			while(i+idx <N && j+idx <N) {
				arr[i+idx][j+idx] += 1;
				idx++;
			}
			
			idx = 0;
			while(i+idx < N && j-idx >=0) {
				arr[i+idx][j-idx] +=1;
				idx++;
			}
			
			idx = 0;
			while(i-idx >= 0 && j+idx <N) {
				arr[i-idx][j+idx] += 1;
				idx++;
			}
			

			for(int n= 0; n<N; n++) {
				for(int m= 0; m<N; m++) {
					if(arr[n][m]==0) {
						
						dfs(n,m,cnt+1);
						
						decrease(i,j);
					}
				}
			}
		}
		
	}

	private static void decrease(int i, int j) {
		for(int n = 0; n<N ;n++) {
			arr[i][n] -= 1;
			arr[n][j] -= 1;
			
		}
		
		int idx = 0;
		while(i-idx >=0 && j-idx >=0) {
			arr[i-idx][j-idx] -= 1;
			idx++;
		}
		
		idx = 0;
		while(i+idx <N && j+idx <N) {
			arr[i+idx][j+idx] -= 1;
			idx++;
		}
		
		idx = 0;
		while(i+idx < N && j-idx >=0) {
			arr[i+idx][j-idx] -=1;
			idx++;
		}
		
		idx = 0;
		while(i-idx >= 0 && j+idx <N) {
			arr[i-idx][j+idx] -= 1;
			idx++;
		}
		
	}

}
