package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2775_BunueMaster {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb  = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "\n");
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int i=1; i<=n; i++)
				arr[i-1] = i;
			
			while(k-->=0) {
			for(int i=n; i>=n; i--) {
				int sum=0;
				for(int j=0; j<i; j++) {
					sum += arr[j];
				}
				arr[i-1] = sum;
			}
			}
			
		}
	}

	
}
