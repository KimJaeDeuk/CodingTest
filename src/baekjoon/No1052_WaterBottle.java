package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1052_WaterBottle {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int i = K;
		int cnt = 0;
		while(N>K) {
			System.out.println(cnt+"번째 : "+N);
			if(N >> 1 < i) {
				System.out.println("작을경우");
				N++;
				cnt++;
			}else {
				N = N >> 1;
			}
		}
		System.out.println(cnt+"번째 : "+N);
		System.out.println("물병 필요 갯수" + cnt);
	}

}
