package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No23253_자료구조는정말최고야 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<M; i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i=0; i<M; i++) {
			
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for(int j=1; j<k; j++) {
				int next = Integer.parseInt(st.nextToken());
				
				if(n < next) {
					System.out.println("No");
					System.exit(0);
				}
				
				n = next;
			}
			
		}
		System.out.println("Yes");
		
	}

}
