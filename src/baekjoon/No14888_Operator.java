package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14888_Operator {
	
	static int remainOperator[] = new int[4];
	static int[] operator_array = new int[10];
	static int[] number_array = new int[11]; 
	static int T = 0;
	static int min = 1000000000;
	static int max = -1000000000;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		 T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i< T; i++) {
			number_array[i] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
		for(int i=0; i< 4; i++) {
			remainOperator[i] = Integer.parseInt(st1.nextToken());
		}
		
		dfs(0);
		
		System.out.println(max + "\n" + min);
	}
	
	
	private static void dfs(int index) {
		
		if(index < T-1) {
			for(int i=0; i<4; i++) {
				if(remainOperator[i]>0)
				{
					operator_array[index] = i;
					remainOperator[i]--;
					dfs(index+1);
					remainOperator[i]++;
				}
			}
		}
		else {
			int result = number_array[0];
			for(int i=0; i<T-1; i++) {

				switch(operator_array[i]) {
					case 0:
						result += number_array[i+1]; 
						break;
					case 1:
						result -= number_array[i+1];
						break;
					case 2:
						result *= number_array[i+1];
						break;
					case 3:
						result /= number_array[i+1];
				}
			}
			min = min<result?min:result;
			max = max>result?max:result;
			
		}
		
	}

}
