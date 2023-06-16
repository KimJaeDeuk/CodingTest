package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No3054_피터팬프레임 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		
		char[][] arr = new char[5][5*line.length()];
		
		for(char[] a : arr) {
			Arrays.fill(a, '.');
		}
		
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<line.length(); j++) {
				
				if(j%3==2) {
					if(i==0||i==4) {
						arr[i][j*5+2] = '*';
					}else if(i==1 || i==3) {
						arr[i][j*5+1] = '*';
						arr[i][j*5+3] = '*';
					}else {
						arr[i][j*5] = '*';
						arr[i][j*5+4] = '*';
						arr[i][j*5+2] = line.charAt(j);
					}
				}else {
					if(i==0||i==4) {
						arr[i][j*5+2] = '#';
					}else if(i==1 || i==3) {
						arr[i][j*5+1] = '#';
						arr[i][j*5+3] = '#';
					}else {
						arr[i][j*5+2] = line.charAt(j);
						
						if(j+1<line.length() && (j+1)%3==2) {
							arr[i][j*5+4] = '*';
						}else {
							arr[i][j*5+4] = '#';
						}
						if(j-1>0 && (j-1)%3==2) {
							arr[i][j*5] = '*';
						}else {
							arr[i][j*5] = '#';
						}
					}
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5*line.length(); j++) {
				if(j!=0 && j%5==4 && j!=5*line.length()-1) continue;
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
