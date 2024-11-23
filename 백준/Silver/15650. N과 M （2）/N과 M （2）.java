import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
//		StringBuilder sb  =new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean visited[] = new boolean[N+1];
		dfs(0, 1, visited);
		
		System.out.println(sb);
		
	}
	private static void dfs(int cnt, int num, boolean visited[]) {
		
		if(cnt == M) {
			for(int i=1; i<=N; i++) {
				if(visited[i]) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		
		for(int i=num; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1, i+1, visited);
				visited[i] = false;
			}
		}
	}
}
