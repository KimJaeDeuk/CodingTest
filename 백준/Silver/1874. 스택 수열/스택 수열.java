import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringBuilder sb  =new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		boolean[] pop = new boolean[N+1];
		int now = 1;
		append(sb, "+");
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(now < num) {
				for(int j=now+1; j<=num; j++) {
					if(!pop[j])
						append(sb, "+");
				}
				append(sb, "-");
				
			} else {
				for(int j = num+1; j<now; j++) {
					if(!pop[j]) {
						System.out.println("NO");
						System.exit(0);
					}
				}
				append(sb, "-");
				
			}
			pop[num] = true;
			now = num;
		}
		System.out.println(sb);
	}
	
	private static void append(StringBuilder sb, String st) {
		sb.append(st).append("\n");
	} 
	
}
