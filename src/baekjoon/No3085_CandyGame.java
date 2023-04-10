package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3085_CandyGame {
	static int N;
	static StringTokenizer st;
	
	static int max=0;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		char[][] candy = new char[N][N];
		for(int i=0; i<N; i++) {
			
			candy[i]  = br.readLine().toCharArray();
			
		}
		
		
		System.out.println( getMaxCandy(candy));
	}
	private static int getMaxCandy(char candy[][]) {

		for(int i=0; i<N; i++) {

			for(int j=0; j<N; j++) {
				
				if(j+1 < N) {
					char tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;

					int ans = checkMax(candy);
					if(ans > max)
						max = ans;
					candy[i][j+1] = candy[i][j];
					candy[i][j] = tmp;

				}
				
				if(i+1 < N) {
					char tmp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = tmp;

					int ans = checkMax(candy);
					if(ans > max)
						max = ans;
					candy[i+1][j] = candy[i][j];
					candy[i][j] = tmp;

				}


				

			}

		}

		return max;
	}
	private static int checkMax(char[][] candy) {
		
		int ans = 1;
		for(int i=0; i<N; i++) {
			
			int cnt=1;
			for(int j=1; j<N; j++) {
				if(candy[i][j] == candy[i][j-1])
					cnt += 1;
				else {
					cnt = 1;
				}
				if(ans < cnt)
					ans = cnt;
			}			
			cnt = 1;

			for(int j=1; j<N; j++) {
				if(candy[j][i] == candy[j-1][i])
					cnt+=1;
				else
					cnt = 1;
				if(ans < cnt)
					ans = cnt;
			}

		}
		return ans;

	}

}
