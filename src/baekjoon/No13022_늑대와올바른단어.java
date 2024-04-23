package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No13022_늑대와올바른단어 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int idx = 0;
		String[] arr = {"w", "o", "l", "f"};
		int word = 1;
		int length = 0;
		for(int i=0; i<line.length(); i++) {
			
			int j = i;
			while(line.substring(j,j+1)== arr[idx]) {
				j++;
			}
			
			length += j-i;
			idx = (idx+1)%4;
		}	
	}

}
