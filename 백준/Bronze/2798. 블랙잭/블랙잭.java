import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	static int result = 0;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr,new boolean[N], 0, 0);
		
		System.out.println(result);
	}


	private static void dfs(int[] arr, boolean visited[], int start, int cnt) {
		
		if(cnt == 3) {
			int sum = 0;
			for(int i=0 ;i<N; i++) {
				if(visited[i]) {
					sum += arr[i];
				}
			}
			if(sum <= M && sum >result) {
				result = sum;
			}
			
			return;
		}
		
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(arr,visited, i+1, cnt+1);
				visited[i] = false;
			}
		}
		
	}
	
}
