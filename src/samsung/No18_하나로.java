package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Tunnel{
	double x;
	double y;
	public Tunnel(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Tunnel(double x) {
		this.x = x;
	}
}

public class No18_하나로 {
	static ArrayList<Tunnel> tunnelList = new ArrayList<>();
	static Stack<Tunnel> stack = new Stack<>();
	static int N;
	static double E;
	static double min;
	static int tc=1;
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/18_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(tc=1; tc<=test_case; tc++) {
			N = Integer.parseInt(br.readLine());
			init(br, new StringTokenizer(br.readLine(), " "));
			
			dfs(0, new boolean[N]);
			System.out.println(Math.round(min));
			sb.append("#").append(tc).append(" ").append(Math.round(min*E)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	private static void dfs(int depth, boolean[] visited) {
		if(depth==N) {
			double result = getLength();
			min = Math.min(min, result);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				stack.push(tunnelList.get(i));
				dfs(depth+1, visited);
				visited[i] = false;
				stack.pop();
			}
		}
	}
	
	private static double getLength() {
		double total = 0;
		
		for(int i=0; i<N-1; i++) {
			Tunnel t1 = stack.get(i);
			Tunnel t2 = stack.get(i+1);
			
			double dist = Math.abs(t1.x - t2.x) + Math.abs(t1.y + t2.y);
			dist = Math.pow(dist,2);
			total += dist;
		}
		return total;
	}
	private static void init(BufferedReader br, StringTokenizer st) throws IOException {
		min = Double.MAX_VALUE;
		tunnelList.clear();
		stack.clear();
		for(int i=0; i<N; i++) {
			tunnelList.add(new Tunnel(Double.parseDouble(st.nextToken())));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			tunnelList.get(i).y = Double.parseDouble(st.nextToken());
		}
			E = Double.parseDouble(br.readLine());
		
	}

}
