package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1051_NumberSquare {

	static int N;
	static int M;
	static int max;
	static int[][] square;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		max = Math.max(N, M);

		square = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				square[i][j] = s.charAt(j)-'0';
			}
		}

		System.out.println( getArea());
	}
	private static int getArea() {
		int len = 1;

		for(int size = max-1; size>0; size--) {
			for(int i=0; i<N-size; i++) {
				for(int j=0; j<M-size; j++) {
					if(square[i][j] == square[i][j+size] && square[i][j]==square[i+size][j] && square[i][j] == square[i+size][j+size]) {
						return(int) Math.pow(size+1,2);
						
					}
				}
			}
		}


		return(int) Math.pow(len,2);
	}

}
