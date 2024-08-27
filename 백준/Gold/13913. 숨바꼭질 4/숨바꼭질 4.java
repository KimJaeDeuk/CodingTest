import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static int su;
	static int dong;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int []visited = new int[100001];
	static int[] time = new int[100001] ;
	 
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		su = Integer.parseInt(st.nextToken());
		dong = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(time[dong]-1);
		int idx = dong;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(idx!=su) {
			stack.push(idx);
			idx = visited[idx];
		}
		stack.push(su);
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
	private static void bfs() {
		queue.add(su);
		time[su] = 1;
		visited[su] = 1;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now==dong) {
				break;
			}
			
			for(int i=-1; i<=1; i++) {
				int next;
				if(i==0) {
					next = now*2;
				}else
					next = now+i;
				
				if(next <0 || next >100000) continue;
				
				if(time[next]==0) {
					queue.add(next);
					time[next] = time[now]+1;
					
					visited[next] = now;
					
				}
			}
			
		}
		
	}

}
