package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2477_MelonCnt {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int bat[][] = new int[6][2];
		
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<2; j++) {
				bat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<6; i++) {
			int a = i+2>5? i+2-6:i+2;
			int b = i+1>5? i+1-6:i+1;
			int c = i+3>5? i+3-6:i+3;
			if(bat[i][0] == bat[a][0]) {
				if(bat[b][0] == bat[c][0])
				{
					int w = bat[i][1] + bat[a][1];
					int h = bat[b][1] + bat[c][1];
					int exc = bat[b][1] * bat[a][1];
					System.out.println((w*h - exc) * K);
					return;
				}
			}	
		}
	}

}
