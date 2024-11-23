import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, 0, new boolean[N], new int[M]);
		System.out.println(sb);
	}
	private static void dfs(int cnt, int n, boolean[] bs, int[] result) {
		
		if(cnt == M) {
			StringBuilder isResult = new StringBuilder();
			for(int num : result ) {
				isResult.append(num).append(" ");
			}
			String resultS = isResult.toString();
			if(!set.contains(resultS)) {
				sb.append(resultS);
				set.add(resultS);
				sb.append("\n");
			}
			return;
		}
		
		for(int i=n; i<N; i++) {
			
			
			result[cnt] = arr[i];
			dfs(cnt+1,i, bs, result);
			
		}
		
	}
}
