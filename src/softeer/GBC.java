package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GBC {
	static int N, M;
	
	static int[] arr = new int[101];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max=0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int nowFloor = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int floor = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			
			for(int j=nowFloor+1; j<=nowFloor+floor; j++) {
				arr[j] = speed;
			}
			nowFloor += floor;
		}
		System.out.println("100층 : "+  arr[100] + " arr[0]" + arr[0]);
		nowFloor = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int floor = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			for(int j=nowFloor+1; j<=nowFloor+floor; j++) {
				if(arr[j]<speed) {
					max = Math.max(speed-arr[j], max);
				}
			}
		}
		System.out.println(max);
		
	}

}


