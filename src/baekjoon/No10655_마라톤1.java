package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CheckPoint{
	int x;
	int y;
	public CheckPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class No10655_마라톤1 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<CheckPoint> list = new ArrayList<CheckPoint>();
		StringTokenizer st;
		int total = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new CheckPoint(x, y));
			if(i>=1) {
				total += getDist(list.get(i-1), list.get(i));
			}
		}
		int min = total;
		
		int idx =0;
		
		for(int i=1; i<N-1; i++) {
			int origin = getDist(list.get(i-1), list.get(i)) + getDist(list.get(i), list.get(i+1));
			
			int jump = getDist(list.get(i-1), list.get(i+1));
			min = Math.min(min, total - origin + jump);
		}
		
		System.out.println(min);
	}
	
	private static int getDist(CheckPoint c1, CheckPoint c2) {
		return Math.abs(c1.x-c2.x) + Math.abs(c1.y-c2.y);
	}
}
