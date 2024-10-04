import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		boolean flag = true;
		Queue<Character> queue = new LinkedList<>();
		int cnt = N*2+1;
		int num = 0;
		int result = 0;
		for(int i=0; i<M; i++) {
			char c= line.charAt(i);
			
			if(flag && c=='I') {
				num++;
				flag = false;
				if(num == cnt) {
					result++;
					num -= 2;
				}
			} else if(!flag && c=='O') {
				num++;
				flag = true;
			} else if(!flag && c=='I') {
				num = 1;
				
			} else if(flag && c=='O') {
				num = 0;
			} 
			
			
		}
		
		System.out.println(result);
		
		
	}
}