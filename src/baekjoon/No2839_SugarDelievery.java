package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2839_SugarDelievery {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int i;
		
		for(i=0;i<=N/3;i++) {
			int five = N-(3*i);
			if(five%5==0) {
				System.out.println((five/5) + i);
				return;
			}
			
		}
		System.out.println(-1);
	}
 
}
