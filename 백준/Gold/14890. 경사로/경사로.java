import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static StringBuilder result = new StringBuilder();
	static int N, L;
	static int[][] arr;
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			checkSpan(i, new boolean[N]);
			checkRow(i, new boolean[N]);
		}
		System.out.println(cnt);
	}

	private static void checkSpan(int x, boolean[] visited) {


		for(int i=1; i<N;) {
			boolean check = false;
			int checkCnt = 0;
			if(Math.abs(arr[x][i] - arr[x][i-1]) == 1) {
				if(arr[x][i] > arr[x][i-1]) {
					if(i < L) {
						return;
					}
					for(int j=i-1; j>=i-L; j--) {
						if(arr[x][i-1] != arr[x][j] || visited[j]) return;

						checkCnt++;
						visited[j] = true;
					}
					if(checkCnt != L) {
						return;
					}
				} else {
					if(i+L-1 >= N) return;
					for(int j=i; j<=i+L-1; j++) {
						if(arr[x][i] != arr[x][j] || visited[j]) return;

						visited[j] = true;
						checkCnt++;
					}
					if(checkCnt != L) {
						return;
					}
					check = true;
				}
			} else if(Math.abs(arr[x][i] - arr[x][i-1]) > 1) {
				return;
			}

			if(check) {
				i = i+L;
			} else {
				i++;
			}
		}
		cnt++;
	}

	private static void checkRow(int y, boolean[] visited) {

		for(int i=1; i<N;) {
			boolean check = false;
			int checkCnt = 0;
			if(Math.abs(arr[i][y] - arr[i-1][y]) == 1) {
				if(arr[i][y] > arr[i-1][y]) {
					if(i < L) {
						return;
					}
					for(int j=i-1; j>=i-L; j--) {
						if(arr[i-1][y] != arr[j][y] || visited[j]) return;

						checkCnt++;
						visited[j] = true;
					}
					if(checkCnt != L) {
						return;
					}
				} else {
					if(i+L-1 >= N) return;

					for(int j=i; j<=i+L-1; j++) {
						if(arr[i][y] != arr[j][y] || visited[j]) return;

						visited[j] = true;
						checkCnt++;
					}
					if(checkCnt != L) {
						return;
					}
					check = true;
				}
			} else if(Math.abs(arr[i][y] - arr[i-1][y]) > 1) {
				return;
			}

			if(check) {
				i = i+L;
			} else {
				i++;
			}
		}
		cnt++;
	}


}