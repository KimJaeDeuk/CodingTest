package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11501_주식 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 1. 주식을 산다
		 * 2. [원하는 만큼] 가지고 있는 주식을 판다
		 * 3. 아무것도 안한다
		 * */
		// 뒤에서 부터 조회해서
		// 해당 값이 그 전보다 크다면 continue하여 그 값보다 큰 값이 나온다면 그 사이의 값을 전부 초기 설정한 값과 비교하여
		// 연산처리
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			long result = 0;
			
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			
			long max = arr[N-1];
			
			long sum = 0;
			int cnt = 0;
			for(int i=N-2; i>=0; i--) {
				
				// 1 1 3 1 5
				// 1 1 3 1 2 을 사고 5에 다 팔기
				
				if(max < arr[i]) {
					// 현재 위치가 그 다음 위치꺼보다 클 경우 그 다음위치까지의 값들을 계산
					result += (max*cnt) - sum;
					sum = 0;
					cnt = 0;
					max = arr[i];
				} else {
					cnt++;
					sum += arr[i];
				}
			}
			if(cnt != 0 ) {
				
				result += (max*cnt) - sum;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);

	}

}
