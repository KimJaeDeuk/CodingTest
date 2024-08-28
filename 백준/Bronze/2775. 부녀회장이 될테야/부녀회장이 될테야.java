import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N+1][M+1];
			for(int i=1; i<=M; i++) {
				arr[0][i] = i;
			}
			for(int i=1; i<=N; i++) {
				
				for(int j=1; j<=M; j++) {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}
			}
			
			sb.append(arr[N][M]).append("\n");
		}
		
		System.out.println(sb);
	}
}


/*
 * 1층	1	3	6	10	15	21	28	36	45
 * 0층 	1	2	3	4	5	6	7	8	9
 */