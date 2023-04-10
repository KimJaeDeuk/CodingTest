package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1018_ChessDraw {

	static StringTokenizer st;
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String line="";
		char[][] chess = new char[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(),"\n");
			line=st.nextToken();
			for(int j=0; j<line.length(); j++) {
				chess[i][j] = line.charAt(j);
			}
		}
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				checkCount(chess, i, j);
			}
		}
		System.out.println(min);
	}

	private static void checkCount(char chess[][], int x, int y) {
		int cntB = 0;
		int cntW = 0;
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				boolean checkB = ((i+j)%2==0); //홀수칸 짝수칸
				
				if((checkB && chess[i][j] != 'B') || (!checkB && chess[i][j] !='W')) {
					cntB++;
				}
				
				if((checkB && chess[i][j] != 'W') || (!checkB && chess[i][j] !='B')) {
					cntW++;
				}
			}
		}
		
		min = Math.min(min, Math.min(cntB, cntW));
	}

}

