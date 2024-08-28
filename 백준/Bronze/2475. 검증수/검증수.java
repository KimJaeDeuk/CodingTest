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

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for(int i=0; i<5; i++) {
			N = Integer.parseInt(st.nextToken());
			sum += (int)(Math.pow(N, 2));
		}
		
		System.out.println(sum%10);
		
	}
	
	
}
