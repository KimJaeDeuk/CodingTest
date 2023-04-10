package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1003_Fibonacci {
	static int fiboArray[][] = new int[41][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		fiboArray[0][0] = 1;
		fiboArray[0][1] = 0;
		fiboArray[1][0] = 0;
		fiboArray[1][1] = 1;
		
		for(int i=2; i<41; i++) {
			fiboArray[i][0] = fiboArray[i-2][0]+fiboArray[i-1][0];
			fiboArray[i][1] = fiboArray[i-2][1]+fiboArray[i-1][1];
		}
		
		while(T-->0) {
		StringTokenizer st = new StringTokenizer(br.readLine(),"\n");
			
		int N = Integer.parseInt(st.nextToken());
		sb.append(fiboArray[N][0]+" "+ fiboArray[N][1]).append("\n");
		
		}
		System.out.println(sb);
	}

}
