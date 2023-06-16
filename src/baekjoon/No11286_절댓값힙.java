package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No11286_절댓값힙 {
	static class Abs{
		int abs;
		int real; 
		public Abs(int a, int r) {
			this.abs = a;
			this.real = r;
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Abs> list = new ArrayList<Abs>();
		PriorityQueue<Abs> queue = new PriorityQueue<Abs>(new Comparator<Abs>() {
			
			public int compare(Abs a1, Abs a2) {
				if(a1.abs==a2.abs) {
					return Integer.compare(a1.real, a2.real);
				}
				return Integer.compare(a1.abs, a2.abs);
				
			}
		});
		
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				if(queue.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					Abs a = queue.poll();
					sb.append(a.real).append("\n");
				}
			}else {
				queue.add(new Abs(Math.abs(n), n));
			}
		}
		System.out.println(sb);
	}

}
