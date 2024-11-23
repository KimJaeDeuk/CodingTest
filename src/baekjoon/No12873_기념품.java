package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No12873_기념품 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		int round = 1;
		
		int before = 0;
		while(list.size() != 1) {
			
			long step = (long)Math.pow(round++, 3);
			
			int target = (int)((step+before-1)%(list.size()));
			
			list.remove(target);
			before = target;
			
		}
		
		System.out.println(list.get(0));
	}

}
