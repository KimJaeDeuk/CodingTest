package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class No1463_MakeOne {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int makeOne[] = new int[1000000];
		
		makeOne[1] = 0;
		makeOne[2] = 1;
		makeOne[3] = 1;
		for(int i=4; i<=N+1; i++) {
			
			if(makeOne[i*3]==0) {
				makeOne[i*3] = makeOne[i]+1;
			}
			if(makeOne[i*2]==0 ) {
				makeOne[i*2] = makeOne[i]+1;
			}
			if(makeOne[i+1]==0 && (i-1)%3!=0 && (i-1)%2!=0) {
				makeOne[i+1] = makeOne[i]+1;
			}
		}
		
		System.out.println(makeOne[N]);
	}

	

}
