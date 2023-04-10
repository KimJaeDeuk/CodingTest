package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2613_Omok {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] p = new int[21][21];
		StringBuffer sb = new StringBuffer(); 
		StringTokenizer st;
		for(int i=1; i<20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<20; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<20; i++) {
			for(int j=1; j<20; j++) {
				if(p[i][j] != 0) {
					int bw = p[i][j];
					
					if(j+5<21 &&p[i][j+1] == bw && p[i][j+2] == bw && p[i][j+3] == bw && p[i][j+4] == bw && p[i][j+5]!=bw && p[i][j-1]!=bw) {
						
							sb.append(bw).append("\n");
							sb.append(i + " " + j);
							System.out.println(sb);
							return;
						
					} else if(i+5<21 &&p[i+1][j] == bw && p[i+2][j] == bw && p[i+3][j] == bw && p[i+4][j] == bw && p[i+5][j]!=bw && p[i-1][j]!=bw){
							
							sb.append(bw).append("\n");
							sb.append(i + " " + j);
							System.out.println(sb);
							return;
						
					} else if(i+5<21 && j+5 <21 &&p[i+1][j+1] == bw && p[i+2][j+2] == bw && p[i+3][j+3] == bw && p[i+4][j+4] == bw && p[i+5][j+5]!=bw && p[i-1][j-1]!=bw) {
						
							sb.append(bw).append("\n");
							sb.append(i + " " + j);
							System.out.println(sb);
							return;
						
					}else if(j-5>=0 && p[i+1][j-1] == bw && p[i+2][j-2] == bw && p[i+3][j-3] == bw && p[i+4][j-4] == bw && p[i+5][j-5]!=bw && p[i-1][j+1]!=bw) {
						
						sb.append(bw).append("\n");
						sb.append((i+4) + " " + (j-4));
						System.out.println(sb);
						return;
					
				}	else if( i-5>=0&& p[i-1][j+1] == bw && p[i-2][j+2] == bw && p[i-3][j+3] == bw && p[i-4][j+4] == bw && p[i-5][j+5]!=bw && p[i+1][j-1]!=bw) {
					
					sb.append(bw).append("\n");
					sb.append((i-4) + " " + (j+4));
					System.out.println(sb);
					return;
				
			}
				}
			}
		}
		System.out.println(0);

	}

}
