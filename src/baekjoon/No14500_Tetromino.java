package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14500_Tetromino {
	
	static StringTokenizer st;
	static int N = 0;
	static int M = 0;
	static int[][] board;
	static int max =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		maxTetro();
		System.out.println(max);
	}
	private static void maxTetro() {
		
		type1();
		
		type2();
		
		type3();
		
		type4();
		
		type5();
		
	}
	
	private static void type1() {	// ㅡ 모양
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(j+3>=M)
					break;
				if(max < board[i][j]+board[i][j+1]+board[i][j+2]+board[i][j+3])
					max = board[i][j]+board[i][j+1]+board[i][j+2]+board[i][j+3];
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i+3>=N)
					break;
				if(max < board[i][j]+board[i+1][j]+board[i+2][j]+board[i+3][j])
					max = board[i][j]+board[i+1][j]+board[i+2][j]+board[i+3][j];
			}
		}
	}
	
	private static void type2() {	//ㅁ 모양
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i+1>=N || j+1>=M)
					break;
				if(max < board[i][j]+board[i+1][j]+board[i+1][j+1]+board[i][j+1])
					max = board[i][j]+board[i+1][j]+board[i+1][j+1]+board[i][j+1];
			}
		}
	}
	
	private static void type3() { // ㅗ 모양
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i+1<N && j+2<M && max < board[i+1][j]+board[i][j+1] + board[i+1][j+2] + board[i+1][j+1]) {
						max = board[i+1][j]+board[i][j+1] + board[i+1][j+2] + board[i+1][j+1];
				}
				
				if(i+1<N && j+2<M && max < board[i][j]+board[i][j+1] + board[i][j+2] + board[i+1][j+1]) {
						max = board[i][j]+board[i][j+1] + board[i][j+2] + board[i+1][j+1];
					}
				
				if(i+2<N && j+1<M && max < board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j+1]) {
					max = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j+1];
				}
				
				if(i+2<N && j+1<M && max < board[i][j+1] + board[i+1][j+1] + board[i+2][j+1] + board[i+1][j]) {
					max = board[i][j+1] + board[i+1][j+1] + board[i+2][j+1] + board[i+1][j];
				}
			}
		}
		
	}
	
	private static void type4() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i+2<N && j+1<M) {
					if(max < board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1])
						max = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1];
					if(max < board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+2][j] )
						max = board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+2][j];
				}
				if(i+1<N && j+2<M) {
					if(max < board[i+1][j] + board[i+1][j+1] + board[i][j+1] + board[i][j+2])
						max = board[i+1][j] + board[i+1][j+1] + board[i][j+1] + board[i][j+2];
					if(max < board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2])
						max = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2];
				}
			}
		}
		
	}
	
	private static void type5() {
		for(int i=0; i< N; i++) {
			for(int j=0; j<M; j++) {										
				if(i+2<N && j+1<M) {	//세로가 길때
					if(max < board[i][j] + board[i][j+1] + board[i+1][j] + board[i+2][j])   // r 모양
						max = board[i][j] + board[i][j+1] + board[i+1][j] + board[i+2][j];
					if(max < board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j+1]) // ㄱ 모양
						max = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j+1];
					if(max < board[i][j] + board[i+2][j+1] + board[i+1][j] + board[i+2][j])   // ㄴ 모양
						max = board[i][j] + board[i+2][j+1] + board[i+1][j] + board[i+2][j];
					if(max < board[i][j+1] + board[i+1][j+1] + board[i+2][j+1] + board[i+2][j]) // ㄴ 거꾸로 
						max = board[i][j+1] + board[i+1][j+1] + board[i+2][j+1] + board[i+2][j];
				}
				if(i+1<N && j+2<M) {
					if(max < board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j])
						max = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j];
					if(max < board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2])
						max = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2];
					if(max < board[i+1][j] + board[i+1][j+1] + board[i+1][j+2] + board[i][j+2])
						max = board[i+1][j] + board[i+1][j+1] + board[i+1][j+2] + board[i][j+2];
					if(max < board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2])
						max = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
				}
			}
		}
		
	}

}
