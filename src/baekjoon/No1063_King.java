package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1063_King {
	static int[][] chess = new int[9][9];
	static int[] k = new int[2];
	static int[] s = new int[2];
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String king = st.nextToken();
		int x =(int)(king.charAt(0) )-64;
		int y = king.charAt(1)-'0';
		chess[x][y] = 2;
		k[0] = x;
		k[1] = y;

		String stone = st.nextToken();
		x = (int)(stone.charAt(0))-64;
		y = stone.charAt(1)-'0';
		chess[x][y] = 4;
		s[0] = x;
		s[1] = y;
		int N = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			moveKing(br.readLine());
		}
		char asc = (char) (k[0] + 64);
		sb.append(asc+String.valueOf(k[1])).append("\n");
		asc = (char) (s[0] + 64);
		sb.append(asc+String.valueOf(s[1])).append("\n");
		System.out.println(sb);
	}
	private static void moveKing(String m) {

		if(m.equals("R")) {
			if(k[0]+1>=9)
				return;
			if(chess[ k[0] +1] [ k[1] ] == 4) {
				if(s[0]+1<9) {
					chess[ k[0] ] [ k[1] ] = 0;
					chess[ k[0] +1 ] [ k[1] ] = 2;
					chess[ s[0] +1 ] [ s[1] ] = 4;
					k[0] += 1;
					s[0] += 1;
				}else {
					return;
				}
			}else {
				chess[ k[0] ] [ k[1] ] = 0;
				chess[ k[0] +1 ] [ k[1] ] = 2;
				k[0] += 1;
			}

		}else if(m.equals("L")) {
			if(k[0]-1==0)
				return;
			if(chess[ k[0] -1 ] [ k[1] ] == 4) {
				if(s[0]-1 >0) {
					chess[ k[0] ] [ k[1] ] = 0;
					chess[ k[0] -1 ] [ k[1] ] = 2;
					chess[ s[0] -1 ] [ s[1] ] = 4;
					k[0] -= 1;
					s[0] -= 1;
				}else {
					return;
				}

			}else {
				chess[ k[0] ] [ k[1] ] = 0;
				chess[ k[0] -1 ] [ k[1]  ] = 2;
				k[0] -= 1;
			}
		}else if(m.equals("B")) {
			if(k[1]-1==0)
				return;
			if(chess[ k[0] ] [ k[1] -1 ] == 4) {
				if(s[1]-1>0) {
					chess[ k[0] ] [ k[1] ] = 0;
					chess[ k[0] ] [ k[1] -1 ] = 2;
					chess[ s[0] ] [ s[1] -1 ] = 4;
					k[1] -= 1;
					s[1] -= 1;
				}else {
					return;
				}

			}else {
				chess[ k[0] ] [ k[1] ] = 0;
				chess[ k[0] ] [ k[1] -1 ] = 2;
				k[1] -= 1;
			}


		}else if(m.equals("T")) {
			if(k[1]+1>=9)
				return;
			if(chess[ k[0] ] [ k[1] +1 ] == 4) {
				if(s[1]+1<9) {
					chess[ k[0] ] [ k[1] ] = 0;
					chess[ k[0] ] [ k[1] +1 ] = 2;
					chess[ s[0] ] [ s[1] +1 ] = 4;
					k[1] += 1;
					s[1] += 1;
				}else {
					return;
				}

			}else {

				chess[ k[0] ] [ k[1] ] = 0;
				chess[ k[0] ] [ k[1] +1 ] = 2;
				k[1] += 1;

			}
		}else if(m.equals("RT")) {
			if(k[0]+1>=9 || k[1]+1>=9)
				return;
			if(chess[ k[0] + 1 ] [ k[1] +1 ] == 4) {
				if(s[0]+1<9 && s[1]+1<9) {
					chess[ k[0] ] [ k[1] ] = 0;
					chess[ k[0] +1] [ k[1] +1 ] = 2;
					chess[ s[0] +1] [ s[1] +1 ] = 4;
					k[0] += 1;
					k[1] += 1;
					s[0] += 1;
					s[1] += 1;
				}else {
					return;
				}

			}else {

				chess[ k[0] ] [ k[1] ] = 0;
				chess[ k[0] +1 ] [ k[1] +1 ] = 2;
				k[0] += 1;
				k[1] += 1;

			}
		}else if(m.equals("RB")) {
			if(k[0]+1>=9 || k[1]-1==0)
				return;
			if(chess[ k[0] + 1 ] [ k[1] -1 ] == 4) {
				if(s[0]+1<9 && s[1]-1>0) {
					chess[ k[0] ] [ k[1] ] = 0;
					chess[ k[0] +1] [ k[1] -1 ] = 2;
					chess[ s[0] +1] [ s[1] -1 ] = 4;
					k[0] += 1;
					k[1] -= 1;
					s[0] += 1;
					s[1] -= 1;
				}else {
					return;
				}

			}else {

				chess[ k[0] ] [ k[1] ] = 0;
				chess[ k[0] +1 ] [ k[1] -1 ] = 2;
				k[0] += 1;
				k[1] -= 1;

			}
		}else if(m.equals("LB")) {
			if(k[0]-1==0 || k[1]-1==0)
				return;
			if(chess[ k[0] - 1 ] [ k[1] -1 ] == 4) {
				if(s[0]-1>0 && s[1]-1>0) {
					chess[ k[0] ] [ k[1] ] = 0;
					chess[ k[0] -1] [ k[1] -1 ] = 2;
					chess[ s[0] -1] [ s[1] -1 ] = 4;
					k[0] -= 1;
					k[1] -= 1;
					s[0] -= 1;
					s[1] -= 1;
				}else {
					return;
				}

			}else {

				chess[ k[0] ] [ k[1] ] = 0;
				chess[ k[0] -1 ] [ k[1] -1 ] = 2;
				k[0] -= 1;
				k[1] -= 1;

			}
		}else if(m.equals("LT")) {
			if(k[0]-1==0 || k[1]+1>=9)
				return;
			if(chess[ k[0] -1 ] [ k[1] + 1 ] == 4) {
				if(s[0]-1 >0 && s[1]+1 < 9) {
					chess[ k[0] ] [ k[1] ] = 0;
					chess[ k[0] -1] [ k[1] +1 ] = 2;
					chess[ s[0]-1] [ s[1] +1 ] = 4;
					k[0] -= 1;
					k[1] += 1;
					s[0] -= 1;
					s[1] += 1;
				}else {
					return;
				}

			}else {

				chess[ k[0] ] [ k[1] ] = 0;
				chess[ k[0] -1 ] [ k[1] +1 ] = 2;
				k[0] -= 1;
				k[1] += 1;
			}

		}

	}

}
