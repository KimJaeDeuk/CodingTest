package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15711_환상의짝꿍 {
	
	static boolean[] sosu = new boolean[2000001];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		ertosthenes();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(TC-->0) {
			st = new StringTokenizer(br.readLine());
			
			long sum = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
			
			if(sum<4)
				sb.append("NO").append("\n");
			else if(sum%2==0) {
				sb.append("YES").append("\n");
			}else {
				if(check(sum-2)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
			
		}
		System.out.println(sb);
		
	}

	private static boolean check(long sum) {
		if(sum<=2000000) return !sosu[(int)sum];
		
		for(Integer i : list) {
			
			if(sum%i==0) {
				return false;
			}
			
		}
		
		return true;
	}

	private static void ertosthenes() {
		sosu[0] = sosu[1] = true;
		
		for(int i=2; i<=2000000; i++) {
			
			if(!sosu[i]) {
				list.add(i);
				
				for(int j=i*2; j<=2000000; j+=i) {
					sosu[j] = true;
				}
			}
			
		}
		
	}
}
