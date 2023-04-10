package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2908_SangSu {
	
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String A = st.nextToken();
		String B = st.nextToken();
		StringBuffer reverse_A = new StringBuffer(A);
		A = reverse_A.reverse().toString();
		StringBuffer reverse_B = new StringBuffer(B);
		B = reverse_B.reverse().toString();
		
		System.out.println(Integer.parseInt(A)>Integer.parseInt(B)?A:B);
		
	}

}
