package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Memo{
	int r;
	int c;
	public Memo(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
public class No16937_두스티커 {
	static int H,W,N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		Memo[] arr = new Memo[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Memo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int max = 0;
		for(int i=0; i<N-1; i++) {
			if((arr[i].r >H && arr[i].c >H) || (arr[i].r >W && arr[i].c >W)) continue;
			for(int j=1; j<N; j++) {
				if(i==j) continue;
				Memo m1 = arr[i];
				Memo m2 = arr[j];
				
				if(m1.r+m2.r <=H && m1.c <=W) {
					max = Math.max((m1.r+m2.r)*m1.c, max);
				}
				if(m1.r+m2.r <=H && m2.c <=W) {
					max = Math.max((m1.r+m2.r)*m2.c, max);
				}
				if(m1.r+m2.c <=H && m1.c <=W) {
					max = Math.max((m1.r+m2.c)*m1.c, max);
				}
				if(m1.r+m2.c <=H && m2.r <=W) {
					max = Math.max((m1.r+m2.c)*m2.r, max);
				}
				if(m1.r+m2.r <=W && m1.c <=H) {
					max = Math.max((m1.r+m2.r)*m1.c, max);
				}
				if(m1.r+m2.r <=W && m2.c <=H) {
					max = Math.max((m1.r+m2.r)*m2.c, max);
				}
				if(m1.r+m2.c <=W && m1.c <=H) {
					max = Math.max((m1.r+m2.c)*m1.c, max);
				}
				if(m1.r+m2.c <=W && m2.r <=H) {
					max = Math.max((m1.r+m2.c)*m2.r, max);
				}
				
				
			}
			
		}
		System.out.println(max);
	}

}
