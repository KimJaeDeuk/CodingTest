package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2578_Bingo {
	static int[][] bingo = new int[5][5];
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++)
				bingo[i][j] = Integer.parseInt(st.nextToken());
		}
		int check = 0;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				check++;
				checkBingo(Integer.parseInt(st.nextToken()));
				if((i+1)*5 + j >= 13) {
					int cnt = checkLine();
					if(cnt >=3) {
						System.out.println(check);
						return;
					}
						
				}
			}
		}

	}
	private static int checkLine() {
		int cnt=0;
		int line=0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(bingo[i][j]!=0)
					break;
				line++;
			}
			if(line==5)
				cnt++;
			line = 0;
			for(int j=0; j<5; j++) {
				if(bingo[j][i]!=0)
					break;
				line++;
			}
			if(line==5)
				cnt++;
			
			line=0;
		}
		
		for(int i=0; i<5; i++) {
			if(bingo[i][i]!=0)
				break;
			line++;
		}
		if(line==5)
			cnt++;
		line = 0;
		for(int i=0; i<5; i++) {
			if(bingo[i][4-i]!=0) {
				break;
			}
			line++;
		}
		if(line==5)
			cnt++;
		return cnt;
		
	}
	private static void checkBingo(int parseInt) {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(bingo[i][j] == parseInt) {
					bingo[i][j] = 0;
					return;
				}
			}
		}
		
	}

}
