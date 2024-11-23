package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GBC {
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] floor = new int[101];
		int nowFloor = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int nextFloor =  Integer.parseInt(st.nextToken());
			int speed =  Integer.parseInt(st.nextToken());
			
			for(int j=nowFloor; j<=nowFloor+nextFloor; j++) {
				floor[j] = speed;
			}
			nowFloor += nextFloor;
		}
		
		int max = 0;
		nowFloor = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int checkFloor = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			
			for(int j=nowFloor; j<=nowFloor+checkFloor; j++) {
				max = Math.max(speed - floor[j], max);
			}
			
			nowFloor += checkFloor;
		}
		
		if(max < 0) max = 0;
		System.out.println(max);
		
	}
	
}
