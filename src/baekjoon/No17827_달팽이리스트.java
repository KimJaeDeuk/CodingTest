package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17827_달팽이리스트 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[i] = value;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			long K  =Integer.parseInt(br.readLine());
			if(K >= N) {
				K = ((K - V) % (N-V)) +V;
				
			}
			sb.append(arr[(int)K]).append("\n");
		}
		System.out.println(sb);
	}

}
// N 6
// V 3 -> 2
// 1 2 3 4 5 6->3
// 2 -> C==1,
// 3 -> C==2, 6, 10
// 4 -> C==3, 7, 11
// 5 -> C==4, 8, 12
// 6 -> C==5, 9, 13

//  K - (V-1) = 9, 10, 11, 12;
//  0,4  1,5 2,6 3,7   %4 == N-V

//  N=6 V=3
//  0	1	2	3	4	5
//    	1	2	3	4	5
//      	6	7	8	9
//			10	11	12	13
//			14	15	16	17
// ((K - V) % (N-V)) +(N-V);
