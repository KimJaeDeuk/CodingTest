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
		
		String one = br.readLine();
		String two = br.readLine();
		String three = br.readLine();
		
		sb.append(Integer.parseInt(one) + Integer.parseInt(two) - Integer.parseInt(three))
			.append("\n")
			.append(Integer.parseInt(one+two) - Integer.parseInt(three));
		
		System.out.println(sb);
		
	}
	
	
}
