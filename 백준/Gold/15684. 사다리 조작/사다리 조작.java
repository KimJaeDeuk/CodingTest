import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// No.15684
public class Main {

	static StringBuilder result = new StringBuilder();
	static int N, M,H;
	static int[][] arr;
	static int resultCnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		// -1 left
		// 1 right
		arr = new int[H+1][N+1];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[a][b+1] = -1;
		}
		for(int i=0; i<=3; i++) {
			dfs(i, 0, new boolean[H+1][N+1]);
		}
		if(resultCnt == Integer.MAX_VALUE) {
			resultCnt = -1;
		}
		System.out.println(resultCnt);
	}
	private static void dfs(int n, int cnt, boolean[][] visited) {
		if (n==cnt ) {

			if(check()) {
				resultCnt = Math.min(resultCnt, n);
				System.out.println(resultCnt);
				System.exit(0);
			}
			return;
		}

		for(int i=1; i<=H; i++) {

			for(int j=1; j<N; j++) {

				if(arr[i][j] == 0 && arr[i][j+1] == 0 && !visited[i][j] && !visited[i][j+1]) {
					visited[i][j] = true;
					visited[i][j+1] = true;
					arr[i][j] = 1;
					arr[i][j+1] = -1;
					dfs(n, cnt+1, visited);
					arr[i][j] = 0;
					arr[i][j+1] = 0;
					visited[i][j] = false;
					visited[i][j+1] = false;
				}

			}

		}


	}
	// i번째 사다리에서 i번째 사다리로 가는지의 체크 로직
	private static boolean check() {

		for(int num=1; num<=N; num++) {
			int now = num;
			for (int i = 1; i <= H; i++) {
				if(arr[i][now] == -1) {
					now--;
				} else if(arr[i][now] == 1) {
					now++;
				}
			}
			if(now != num) {
				return false;
			}
		}
		return true;
	}

}