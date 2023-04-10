package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2675_StringRepeat {
	
	static int T;
	static int R;
	static String S;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			R = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			
			sb.append(getRepeat()).append("\n");
		}
		System.out.println(sb);
	}
	private static String getRepeat() {
		String repeatString="";
		for(int i=0; i<S.length();i++) {
			for(int j=0; j<R; j++)
			repeatString += S.charAt(i);
		}
		
		return repeatString;
	}

}
