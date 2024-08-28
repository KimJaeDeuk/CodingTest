import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dfs(new int[N], 1, 0, 0);
		System.out.println(sb);
	}
	
	
	private static void dfs(int[] arr, int start, int cnt, int idx) {
		
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=start; i<=N; i++) {
			
			arr[idx] = i;
			dfs(arr, i, cnt+1, idx+1);
		}
		
	}
	
	
}
