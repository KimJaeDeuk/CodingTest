package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2491_Sequence {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		int[][] sep = new int[2][N];
		sep[0][0] = 1;
		sep[1][0] = 1;
		int max = 0;
		for(int i=1; i<N; i++) {
			
			if(seq[i-1] < seq[i]) {
				sep[0][i] = sep[0][i-1]+1;
				sep[1][i] = 1;
			}
			else if(seq[i-1]>seq[i]){
				sep[1][i] = sep[1][i-1]+1;
				sep[0][i] = 1;
			}
			else {
				sep[0][i] = sep[0][i-1]+1;
				sep[1][i] = sep[1][i-1]+1;
			}
		}
		int answer = 0;
		for(int i=0; i<N; i++) {
			answer = Math.max(sep[0][i],sep[1][i]);
			max = Math.max(answer, max);
		}
		System.out.println(max);
	}

}
