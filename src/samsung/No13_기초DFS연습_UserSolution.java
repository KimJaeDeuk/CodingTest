package samsung;

public class No13_기초DFS연습_UserSolution {
	
	private int[][] path;
	
	private int[] stack;
	private int size; 
	
	
	public void dfs_init(int N, int[][] path) {
		this.size = N;
		this.path = path;
	}
	
	public int dfs(int N) {
		
		stack = new int[size];
		boolean visited[] = new boolean[this.size];
		int top = -1;
		
		stack[++top] = N;
		
		while(top != -1) {
			int curr = stack[top--];
			
			if(curr >N) return curr;
			
			for(int next = size-1; next >=0; next--) {
				if(!visited[next] && path[next][0]==curr) {
					
					stack[++top] = path[next][1];
					visited[next] = true;
				}
			}
			
			
		}
		
		return -1;
	}

	
}