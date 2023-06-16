package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No2485_가로수 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int before = Integer.parseInt(br.readLine());
		for(int i=0; i<N-1; i++) {
			int after = Integer.parseInt(br.readLine());
			list.add(after-before);
			before = after;
		}
		
		int cnt = 0;
		
		int gcd = gcd(list.get(0), list.get(1));
		for(int i=1; i<N-2; i++) {
			gcd = gcd(gcd, list.get(i+1));
			if(gcd==1) {
			
				break;
			}
		}
		
		for(int i=0; i<N-1; i++) {
			int num = list.get(i)/gcd -1;
			cnt += num;
		}
		System.out.println(cnt);
		
	}

	private static int gcd(Integer a, Integer b) {
		
		if(a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

}

/*
 * 
 *
 * 4 6 6
 * 
 * 2 |2 2 |2 |2 2 |2 | 2
 * 
 * 
 * */
 