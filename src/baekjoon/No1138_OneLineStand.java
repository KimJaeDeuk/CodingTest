package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1138_OneLineStand {
	public static void main(String[] args) throws Exception{
		int[] left;
		int[] line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		left = new int[N];
		line = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			left[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if(cnt==left[i] && line[j]==0) {
					line[j] = i+1;
					break;
				}
				if(line[j]==0)
					cnt++;
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<N; i++)
			sb.append(line[i]).append(" ");
		System.out.println(sb);
	}

}
