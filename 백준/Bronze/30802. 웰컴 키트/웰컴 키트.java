import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[6];
		
		for(int i=0; i<6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int tCount = 0;
		for(int i=0; i<6; i++) {
			
			if(arr[i] % T == 0) {
				tCount += (arr[i]/T);
			} else {
				tCount += arr[i]/T +1;
			}
		}
		
		sb.append(tCount).append("\n");
		
		sb.append(N/P).append(" ").append(N%P);
		
		System.out.println(sb);
	}
	
}
