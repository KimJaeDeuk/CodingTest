package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 금고털이 {
	static class Bosuk{
		int m;
		int p;
		
		public Bosuk(int m, int p){
			this.m = m;
			this.p = p;
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Bosuk> list = new ArrayList<Bosuk>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Bosuk(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, new Comparator<Bosuk>() {

			@Override
			public int compare(Bosuk o1, Bosuk o2) {
				return Integer.compare(o2.p, o1.p);
			}
			
		});
	
		int sum = 0;
		for(int i=0; i<list.size(); i++){
			
			Bosuk b = list.get(i);
			int count = b.m;
			int price = b.p;
			
			if(W-count >0) {
				W -= count;
				sum += count*price;
				//list.remove(0);
			}else {
				sum += price*W;
				break;
			}
			
			if(W==0) {
				break;
			}
		}
		System.out.println(sum);
	}

}
