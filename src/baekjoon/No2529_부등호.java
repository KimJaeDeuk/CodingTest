package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2529_부등호 {
	static char arr[];
	static String max="",min = "";
	static boolean visited[] = new boolean[10];
	static int N;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		for(int i=0; i<=N; i++) {
			max += "0";
			min += "9";
		}
		
		dfs(0, 0, new int[N+1]);
		System.out.println(max + "\n" + min);
	}
	private static void dfs(int depth, int before, int[] out) {
		
		if(depth==N+1) {
			String result ="";
			for(int i : out)
				result += i;
			
			max = max.compareTo(result) > 0 ? max : result;
			min = min.compareTo(result) > 0 ? result : min;
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(depth==0) {
				visited[i] = true;
				out[depth] = i;
				dfs(depth+1, i, out);
				visited[i] = false;
			}
			else if(!visited[i]) {
				
				if(arr[depth-1]=='>' && before > i ) {
					visited[i] = true;
					out[depth] = i;
					dfs(depth+1, i, out);
					visited[i] = false;
				}else if(arr[depth-1] == '<' && before < i){
					visited[i] = true;
					out[depth] = i;
					dfs(depth+1, i, out);
					visited[i] = false;
				}
			}
		}
		
		
		
	}

}
