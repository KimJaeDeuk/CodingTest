import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		for(int i=N-1; i>=1; i--) {
			
			String strNum = String.valueOf(i);
			int sum = 0;
			for(int j=0; j<strNum.length(); j++) {
				sum += Integer.parseInt(strNum.substring(j,j+1));
			}
			
			if(N == i + sum) {
				min = i;
			}
			
		}
		sb.append(min == Integer.MAX_VALUE ? 0 : min);
		System.out.println(sb);
	}
}
