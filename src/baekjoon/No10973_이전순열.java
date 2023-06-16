package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
		//1 ,2 ,3 4
		/* 1 2 4 3
		 * 1 3 2 4
		 * 1 3 4 2
		 * 1 4 2 3
		 * 1 4 3 2
		 * 2 1 3 4
		 * 2 1 4 3
		 * 2 3 1 4
		 * 2 3 4 1
		 * 3 1 2 4
		 * 3 2 1 4
		 * 3 2 4 1
		 * 3 4 1 2
		 * 3 4 2 1
		 * 
		 * 1 2 3 4 5
		 * 1 2 3 5 4
		 * 1 2 4 3 5
		 * 1 2 4 5 3 
		 * 1 3 2 4 5
		 * 1 3 2 5 4
		 * 1 3 4 2 5
		 * 1 3 4 5 2
		 * 1 4 
		 * */
public class No10973_이전순열 {
	static int cnt=0;
	static int N;
	static int arr[];
	static String input="";
	static String before="";
	static boolean check = false;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			input += arr[i];
		}
		if(arr[0]==1 && arr[N-1]==N) {
			System.out.println(-1);
			System.exit(0);
		}
		
	}
	
}
