package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class P{
	int p;
	int time;
	public P(int p, int t) {
		this.p = p;
		this.time = t;
	}
}
public class No13549_숨바꼭질3 {
	
	static int order;
	static int elder;
	static Queue<P> q = new LinkedList<P>();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int result = Integer.MAX_VALUE;
	static int a[] = {1, -1};
	static int arr[] = new int[100001];
	static boolean visited[] = new boolean[100001];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String l[] = line.split(" ");
		order = Integer.parseInt(l[0]);
		elder = Integer.parseInt(l[1]);
		Arrays.fill(arr, Integer.MAX_VALUE);
		bfs();
		System.out.println(result);
	}
	private static void bfs() {
		q.add(new P(order, 0));
		arr[order] = 0;
		visited[order] = true;
		while(!q.isEmpty()) {
			
			P p = q.poll();
			
			int qx = p.p;
			int qTime = p.time;
			
			if(qx == elder) {
				result = Math.min(result, qTime);
				q.clear();
				return;
			}
			Iterator<P> iter = q.iterator();
			
			while(iter.hasNext()) {
				P iterQ = iter.next();
				
				q.add(new P(iterQ.p*2, iterQ.time));
			}
			
			for(int k=0; k<2; k++) {
				
				int dx =  qx + a[k];  
				
				if(dx<0 || dx>100000) continue;
				
				if(arr[dx] > qTime+1) {
					if(!visited[dx]){
						q.add(new P(dx, qTime+1));
						visited[dx] = true;
						arr[dx] = qTime+1;
					} 
				}
			}
			
		}
		
	}

}
