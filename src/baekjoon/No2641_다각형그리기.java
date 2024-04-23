package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2641_다각형그리기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> pho = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pho.add(Integer.parseInt(st.nextToken()));
		}
		
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int input[] = new int[N];
			for(int j=0; j<N; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			boolean isSuccess = false;
			for(int j=0; j<N; j++) {
				//System.out.println("start searchWord idx : " + j );
				int isRotate = 0;
				int isReverse = 0;
				//System.out.println("origin");
				for(int increase = 0;increase<N;increase++) {
					if(pho.get(increase) != input[(j+increase)%N]) {
						break;
					}
					isRotate++;	
				}
				if(isRotate == N) {
					isSuccess = true;
					break;
				}
				for(int decrease = N-1, k = 0;decrease>=0;decrease--, k++) {
					//System.out.println("index: origin["+k + ",target:" + (N+decrease-j)%N+"]");
					int value = (input[(N+decrease-j)%N]+2)%4;
					if(value == 0 )value = 4;
					
					//System.out.println("value: origin["+pho.get(k) + ",target:" +(value)+"]");
					
					if(pho.get((k)) != value) {
						break;
					}
					
					isReverse++;	
				}
				if(isRotate == N || isReverse == N) {
					isSuccess = true;
					break;
				}
			}
			
			if(isSuccess) {
				cnt++;
				for(int j=0; j<N; j++) sb.append(input[j]).append(" ");
				sb.append("\n");
			}
		}
		
		sb.insert(0, cnt+"\n");
		System.out.println(sb.toString());
	}

}
