package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No8_중위순회 {
	static char tree[];
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/8_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		for(int tc=1; tc<=10; tc++) {
			N = Integer.parseInt(br.readLine());
			
			tree = new char[N+1];
			
			for(int i=1; i<=N; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				
				tree[i] = st.nextToken().charAt(0);
				
			}
						
			
			
			
			
			sb.append("#").append(tc).append(" ");
			inOrder(1);
			sb.append("\n");
		}

		
		System.out.println(sb);
	}
	private static void inOrder(int idx) {
		
		if(idx > N) return;

		inOrder(idx*2);

		sb.append(tree[idx]);
		inOrder(idx*2+1);

		
	}

}
