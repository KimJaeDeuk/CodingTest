import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(;;) {
			
			String str = br.readLine();
			if(str.equals("0")) break;
			boolean check = true;
			for(int i=0; i<str.length()/2; i++) {
				
				if(str.charAt(i) != str.charAt(str.length()-1 -i)) {
					check = false;
					break;
				}
				
			}
			
			if(check) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
		}
		
		
		
		System.out.println(sb);
	}
	
}
