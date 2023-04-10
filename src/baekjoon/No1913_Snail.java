package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1913_Snail {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int xyWant = Integer.parseInt(br.readLine());
		int snail[][] = new int[N][N];
		
		int num = N * N;
//		int []x_seq = {1,0,-1,0};
//		int []y_seq = {0,1,0,-1};
		int i=0;
		int x=0;
		int y=0;
		int answer_x=0;
		int answer_y=0;
		snail[x][y] = num;
		num -= 1;
		while(num>=1) {
			
			
				
//			if(x+x_seq[i] <N  && y+y_seq[i] <N && x+x_seq[i]>=0 && y+y_seq[i]>=0 && snail[x+x_seq[i]][y+y_seq[i]]==0) {
//				
//			}
			while(y+1<N && snail[y+1][x] == 0)
			{
				y++;
				snail[y][x] = num;
				num--;
			}
			while(x+1<N && snail[y][x+1] == 0)
			{
				x++;
				snail[y][x] = num;
				num--;
			}
			while(y-1>=0 && snail[y-1][x] == 0)
			{
				y--;
				snail[y][x] = num;
				num--;
			}
			while(x-1>=0 && snail[y][x-1] == 0)
			{
				x--;
				snail[y][x] = num;
				num--;
			}
		}
		
		for( i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(snail[i][j] == xyWant) {
					answer_x = i+1;
					answer_y = j+1;
				}
				sb.append(snail[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(answer_x + " " + answer_y);
		System.out.println(sb);
	}

}
