package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No11536_줄세우기 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String arr[] = new String[N];
		String sort[] = new String[N];
		
		String name = "";
		for(int i=0; i<N; i++) {
			name = br.readLine();
			arr[i] = name;
			sort[i] = name;
		}
		
		Arrays.sort(sort);
		//오름차순
		int cnt = 0;
		int reverse_cnt = 0;
		for(int i=0; i<N; i++) {
			int reverse_num = N-i-1;
			if(sort[i].equals(arr[i])) {
				cnt++;
			}
			if(sort[reverse_num].equals(arr[i]))
				reverse_cnt++;
		}
		if(cnt==N) System.out.println("INCREASING");
		else if(reverse_cnt==N) System.out.println("DECREASING");
		else System.out.println("NEITHER");
		
		
	}

}
