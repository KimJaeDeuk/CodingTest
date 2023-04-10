package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class No1009_Bunsan {
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		
	
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(getOnePoint(a,b)).append("\n");
		}
		System.out.println(sb);
	}

	private static int getOnePoint(int a, int b) {
		if(a%10 == 0)
			return 10;
		int result=1;
		for(int i =0; i<b;i++) {
			result = result * a;
			while(result>10) {
				result = result % 10;
			}
		}
		return result;
	}
}