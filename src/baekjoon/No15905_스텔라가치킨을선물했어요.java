package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No15905_스텔라가치킨을선물했어요 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			
			public int compare(int[] o1, int[] o2) {
				int diff = Integer.compare(o2[0], o1[0]);
				if(diff == 0) {
					return Integer.compare(o1[1], o2[1]);
				} 
				return Integer.compare(o2[0], o1[0]);
			}
		});
		
		int cnt = 0;
		
		int lastScore = arr[4][0];
		
		for(int i=5; i<N; i++) {
			if(lastScore == arr[i][0]) {
				cnt++;
			}else {
				break;
			}
		}
		
		System.out.println(cnt);
	}

}
