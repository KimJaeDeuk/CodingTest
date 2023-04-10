package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10157_MoveSeat {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[C][R];
		int num=1;
		
		int ax=0;
		int ay=0;
		
		int i=0;
		int j=0;
		arr[i][j] = num;
		
		if(K> C*R) {
			System.out.println(0);
			return;
		}
		while(num<K) {
			
			while(j+1<R && arr[i][j+1]==0) {
				j++;
				num++;
				arr[i][j] = num;
			}
			
			while(i+1<C && arr[i+1][j]==0) {
				i++;
				num++;
				arr[i][j] = num;
			}
			
			
			while(j-1>=0 && arr[i][j-1]==0) {
				j--;
				num++;
				arr[i][j] = num;
			}
			
			while(i-1>=0 && arr[i-1][j]==0) {
				i--;
				num++;
				arr[i][j] = num;
			}
			
				
		}
		for(int k=0; k<C; k++) {
			for(int l=0; l<R; l++) {
				if(arr[k][l]==K) {
					ax = k+1;
					ay = l+1;
				}
			}
		}
		System.out.println(ax+" " + ay);
		

	}

}
