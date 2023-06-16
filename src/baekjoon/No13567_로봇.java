package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13567_로봇 {
	static int direction = 0;
	//turn 0 +1   turn 1 -1
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int nowX = 0;
		int nowY = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			String order = st.nextToken();
			
			if(order.equals("MOVE")) {
				int dist = Integer.parseInt(st.nextToken());
				
				nowX = nowX + dx[direction]*dist;
				nowY = nowY + dy[direction]*dist;
				
				if(nowX<0 || nowY < 0 || nowX>M || nowY>M) {
					System.out.println(-1);
					System.exit(0);
				}
				
			}else {
				int dir = Integer.parseInt(st.nextToken());
					
				if(dir==0) {
					direction = (direction+1)%4;
				}else {
					direction = (4+direction-1)%4;
				}
			}
		}
		System.out.println(nowY + " " + nowX);

	}

}
