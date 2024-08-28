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
//		StringTokenizer st;
		String str = "";
		while((str = br.readLine()) != null) {
			String[] arr = str.split(" ");
			sb.append(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])).append("\n");
		}
		System.out.println(sb);
	}
	
	
}
