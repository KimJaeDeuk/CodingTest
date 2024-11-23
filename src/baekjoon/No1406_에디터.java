package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1406_에디터 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		String line = br.readLine();
		
		
		
		for(int i=0; i<line.length(); i++) {
			sb.append(line.charAt(i));
		}
		int pointer = sb.length();
	
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String ope = st.nextToken();
			
			if(ope.equals("L") && pointer>0) {
				pointer--;
			}else if(ope.equals("D") && pointer<sb.length()) {
				pointer++;
			}else if(ope.equals("B") && pointer!=0) {
				sb.deleteCharAt(pointer-1);
				pointer--;
			}else if(ope.equals("P")) {
				String c =  st.nextToken();
				if(sb.length()==pointer)
					sb.append(c);
				else
					sb.insert(pointer, c);
				pointer++;
			}
		}
		System.out.println(sb.toString());
		
	}

}
