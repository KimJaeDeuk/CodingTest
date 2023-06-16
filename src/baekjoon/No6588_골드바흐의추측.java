package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No6588_골드바흐의추측 {
	static boolean arr[] = new boolean[1000001];
	static final String wrong = "Goldbach's conjecture is wrong.";
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		for(int i=3; i<arr.length; i++) {
			if(!arr[i]) {
				make(i);
				list.add(i);
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				break;
			}
			
			sb.append(check(num)).append("\n");
			
			
		}
		System.out.println(sb.toString());
	}
	private static String check(int num) {
		
		int start = list.get(0);
		
		
		for(int i=0; i<list.size(); i++) {
			if(!arr[num-list.get(i)]) {
				return num + " = " + list.get(i) + " + " + (num - list.get(i));
			}
		}
		
		return wrong;
	}
	private static void make(int num) {
		
		int i = 2;
		
		while(num*i<arr.length) {
			
			arr[num*i] = true;
			i++;
		}
	}

}
