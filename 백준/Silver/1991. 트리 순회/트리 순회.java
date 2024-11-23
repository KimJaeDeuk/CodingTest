import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] tree = new int[27][2];
	static StringBuilder result = new StringBuilder();
	static StringBuilder preOrder = new StringBuilder();
	static StringBuilder inOrder = new StringBuilder();
	static StringBuilder postOrder = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int target = 0;
		StringTokenizer st;
		for(int i=0; i<tree.length; i++) {
			Arrays.fill(tree[i], -1);
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(left != '.') {
				tree[parent-'A'][0] = left-'A'; 
			}
			
			if(right != '.') {
				tree[parent-'A'][1] = right-'A';
			}
			
		}
		
		
		dfs(target);
		
		result.append(preOrder).append("\n").append(inOrder).append("\n").append(postOrder);
		
		System.out.println(result);
	}
	private static void dfs(int target) {
		
		if(target == -1) {
			return;
		}
		
		preOrder.append((char)(target+'A'));
		dfs(tree[target][0]);
		inOrder.append((char)(target+'A'));
		dfs(tree[target][1]);
		postOrder.append((char)(target+'A'));
		
		
	}
}