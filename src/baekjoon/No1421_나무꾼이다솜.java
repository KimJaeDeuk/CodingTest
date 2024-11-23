package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1421_나무꾼이다솜 {

	public static void main(String[] args) throws Exception{
		long max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W= Integer.parseInt(st.nextToken());
		int wood[] = new int[N];
		for(int i=0; i<N; i++) {
			wood[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(wood);
		
		for(int len=1; len<=wood[N-1]; len++) {
			long sum = 0;
//			System.out.println("자를길이:" + len);
			for(int i = 0 ;i <N; i++) {
				if(wood[i] < len) continue;
				
				int cnt = 0;
				int woLength= wood[i];
				int woodCnt = 1;
		
				woodCnt = woLength / len;
				cnt =( woLength%len == 0) ? woodCnt - 1 : woodCnt;
				
				long seq = (len*W*woodCnt) - (cnt*C);
				if(seq > 0) {
					 
//					woLength -= woodCnt*len;
//					System.out.println(i+"번째 나무길이 : " + wood[i] +" 남은길이:" + woLength+" 토막수 : " + (woodCnt) + " 자른횟수: " + cnt);
					sum+=seq;
				}
			}
			max = Math.max(sum, max);
//			System.out.println(max);
		}
		
		System.out.println(max);
	}

}
