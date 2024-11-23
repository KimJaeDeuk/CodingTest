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
	
	static int maxX = 0;
	static int maxY = 0;
	static int maxSum = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H,W,N;
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		Memo[] arr = new Memo[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Memo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<N-1; i++) {
			Memo first = arr[i];
			int fx = first.r;
			int fy = first.c;
			for(int j=1; j<N; j++) {
				if(i==j) continue;
				
				Memo second = arr[j];
				int sx = second.r;
				int sy = second.c;
				
				makeMaxSum(fx, fy, sx, sy, H, W);
				
				makeMaxSum(fx, fy, sx, sy, W, H);
				
			}
		}
		System.out.println(maxSum);
	}
	
	public static int sumSquare(int a1, int a2, int b1, int b2) {
		return (a1*a2) + (b1*b2);
	}
	
	public static void makeMaxSum(int fx, int fy, int sx, int sy, int H, int W) {
		
		if(fx + sx <=H && Math.max(fy,sy) <=W) {
			maxSum = Math.max(maxSum,sumSquare(fx, fy, sx, sy));
		} else if( fx + sy <= H && Math.max(fy,sx) <= W) {
			maxSum = Math.max(maxSum,sumSquare(fx, fy, sx, sy));
		} else if( fy + sx <= H && Math.max(fx,sy) <= W) {
			maxSum = Math.max(maxSum,sumSquare(fx, fy, sx, sy));
		} else if( fy + sy <= H && Math.max(fx, sx) <= W) {
			maxSum = Math.max(maxSum,sumSquare(fx, fy, sx, sy));
		}
		
	}
}
