package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15719_중복된숫자 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		boolean[] arr = new boolean[N];
		int num = 0;
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(!arr[a]) {
				arr[a] = true;
			}else {
				System.out.println(a);
				break;
			}
		}

	}

}
