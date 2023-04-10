package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No8979_Olympic {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int [][]rank = new int[N][5];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			rank[i][0] = Integer.parseInt(st.nextToken());
			rank[i][1] = Integer.parseInt(st.nextToken());
			rank[i][2] = Integer.parseInt(st.nextToken());
			rank[i][3] = Integer.parseInt(st.nextToken());
			rank[i][4] = N;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				if(rank[j-1][1] < rank[j][1]) {
					rank[j][4]--;
				}
				else if(rank[j-1][1] == rank[j][1]) {
					if(rank[j-1][1] < rank[j][1]) {
						rank[j][4]--;
					}
					else if(rank[j-1][1] == rank[j][1]) {
						
					}
					else rank[j-1][4]--;
				}
				else rank[j-1][4]--;
			}
		}
	}

}
