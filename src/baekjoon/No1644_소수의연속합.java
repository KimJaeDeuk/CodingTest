package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1644_소수의연속합 {
	static boolean[] sosu = new boolean[4000001];
	static int cnt=0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.println(0);
			return;
		}
		//소수만들기
		for(int i=2; i<sosu.length; i++) {
			if(!sosu[i]) {
				make(i);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=2; i<sosu.length; i++) {
			if(!sosu[i]) list.add(i); 
		}
		
		
		for(int i=0; i<list.size(); i++) {
			
			int sum = 0;
			for(int j=i; j<list.size(); j++) {
				sum += list.get(j);
				if(sum>n) {
					break;
				}else if(sum==n) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}


	private static void make(int num) {
		
		int i=2;
		while(num*i<sosu.length) {
			
			sosu[num*i]=true;
			i++;
		}
		
	}


}
