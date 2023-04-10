package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18111_MineCraft {

	static int[][] bottom;
	static int N, M, B;
	static StringTokenizer st;
	static int max=0;
	static int min= 257;
	static int time = Integer.MAX_VALUE;
	static int height;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		bottom = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				bottom[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, bottom[i][j]);
				min =Math.min(min,  bottom[i][j]);
			}
		}

		int arr[] = getHeight();
		System.out.println(arr[0] + " " + arr[1]);

	}
	private static int[] getHeight() {
		
		for(int hNum=min; hNum<=max; hNum++) {
			int block = B;
			int t = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					
					if(hNum==bottom[i][j]) {
						continue;
					}
					else if(hNum> bottom[i][j]){
						block -=  hNum-bottom[i][j];
						t += hNum-bottom[i][j];
					}
					else {
						block += bottom[i][j] - hNum;
						t += 2*(bottom[i][j] - hNum);
					}
				}
			}
			if(block < 0)
				continue;
		
			if(time > t) {
				time = t;
				height = hNum;
			}
			else if(time == t)
				height = Math.max(height, hNum);
			
		}
		
		int arr[] =  {time, height};
		
		return arr;
	}

}
