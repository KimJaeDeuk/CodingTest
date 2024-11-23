import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			int lcm = n*m / getGcd(n,m);
			
			int result = -1;
			
			for(int i=x; i<=lcm; i+=n) {
				
				if(i%m == y) {
					result = i+1;
					
					break;
				}
				
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int getGcd(int n, int m) {
		
		
		
		while(m!=0) {
			int r = m;
			m = n%m;
			n = r;
		}
		
		return n;
	}
}
