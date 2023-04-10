package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2156_GrapeDrink {
	
	static int n;
	static int[] amount = new int[10000];
	static int[][] sum;
	static int max=0;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "\n");
			amount[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(getMax());
		
	}
	private static int getMax() {
		
		sum = new int[3][n];
		
		if(n<2) {
			if(n==0)
				return amount[0];
			else
				return amount[0]+amount[1];
		}
		if(n<3) {
			int sum = amount[0]+amount[2];
			if(sum < amount[0]+amount[1] )
				sum = amount[0]+amount[1];
			
			if(sum < amount[1]+amount[2])
				sum = amount[1]+amount[2];
			return sum;	
		}
		sum[0][0] = amount[0];
		sum[0][1] = amount[0]+amount[1];
		sum[1][1] = amount[1];
		sum[2][2] = amount[2];
		sum[1][2] = amount[0] + amount[2];
		sum[0][2] = amount[1] + amount[2];
		
		for(int i=3; i<n; i++) {
			sum[0][i] = (sum[1][i-1] > sum[2][i-1])?sum[1][i-1]+amount[i]:sum[2][i-1]+amount[i];
			sum[1][i] = amount[i] + Math.max(sum[0][i-2], Math.max(sum[1][i-2], sum[2][i-2]));
			sum[2][i] = amount[i] + Math.max(sum[0][i-3], Math.max(sum[1][i-3], sum[2][i-3]));
		}
		

		max = Math.max(sum[0][n-1], Math.max(sum[1][n-1], sum[2][n-1]));
		
		max = max > Math.max(sum[0][n-2], Math.max(sum[1][n-2], sum[2][n-2]))?max:Math.max(sum[0][n-2], Math.max(sum[1][n-2], sum[2][n-2]));
		return max; 
	}

}
