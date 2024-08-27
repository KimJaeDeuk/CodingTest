package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> num_list = new ArrayList<>();
		
		ArrayList<Character> calc_list = new ArrayList<>();
		
		String line = br.readLine();
		int s = 0;
		for(int i=0; i<line.length(); i++) {
			
			char a = line.charAt(i);
			if(a=='-' || a == '+') {
				num_list.add(Integer.parseInt(line.substring(s,i)));
				calc_list.add(a);
				s = i+1;
			} 
		}
		num_list.add(Integer.parseInt(line.substring(s,line.length())));
//		System.out.println(num_list.toString());
//		System.out.println(calc_list.toString());
		boolean minus = false;
		int result = num_list.get(0);
		int idx = 1;
		for(int i=0; i<calc_list.size(); i++) {
			char calc = calc_list.get(i);
			if(!minus && calc_list.get(i) == '-') {
				minus = true;
				idx = i+1;
			} 
			
			else if(minus && calc_list.get(i) == '-' ) {
				int sum = 0;
				for(int j=idx; j<=i; j++) {
					sum += num_list.get(j);
				}
				result -= sum;
				idx = i+1;
			} else if(!minus && calc_list.get(i) == '+') {
				result += num_list.get(i+1);
			}
			
			
		}
		int sum = 0;
		for(int i=idx; i<num_list.size(); i++) {
			sum += num_list.get(i);
		}
		if(minus) {
			result -= sum;
		}
		
		System.out.println(result);
	}

}
