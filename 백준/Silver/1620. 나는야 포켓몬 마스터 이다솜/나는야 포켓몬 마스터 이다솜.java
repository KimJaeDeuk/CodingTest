import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		String[] names = new String[N+1];
		HashMap<String,Integer> sequences = new HashMap<>();
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			names[i] = name;
			sequences.put(name, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			char firstWord = input.charAt(0);
			// 입력값 이름
			if(((firstWord - 'a' >= 0) && (firstWord - 'a' <26)) || ((firstWord - 'A' >= 0) && (firstWord - 'A' <26))) {
				sb.append(sequences.get(input));
			} 
			// 입력값 숫자
			else {
				sb.append(names[Integer.parseInt(input)]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
