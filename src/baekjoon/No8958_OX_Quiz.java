package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No8958_OX_Quiz {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int cnt=0;
			int sum=0;
			StringTokenizer st= new StringTokenizer(br.readLine(),"\n");
			String s = st.nextToken();
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == 'O') {
					cnt++;
				}
				else {
					cnt=0;
				}
				sum+=cnt;
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}

}
