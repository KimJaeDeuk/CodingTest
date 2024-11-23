import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = Integer.MIN_VALUE;
		
		int idx = 0;
		for(int i=1; i<=9; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(max < num) {
				max = num;
				idx = i;
			}
		}
		
		sb.append(max).append("\n").append(idx);
		
		System.out.println(sb);
	}
	
	
}
