package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1978_소수찾기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(check(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);

	

	}
	private static boolean check(int num) {
		if(num <= 1) {
			return false;
		}
		
		for(int i=2; i<=num/2; i++) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
}
