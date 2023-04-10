package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1417_KuckHwaeSungue {
	
	static int N;
	static int hubo[];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		hubo = new int[N+1];
		int sum = 0;
		for(int i=1; i<=N; i++) {
			hubo[i] = Integer.parseInt(br.readLine());
			sum += hubo[i];
		}
		
		int cnt=0;
		while(check()) {
			int max = 0;
			int idx = 0;
			for(int i=2; i<=N; i++) {
				if(max < hubo[i]) {
					max = hubo[i];
					idx = i;
				}
			}
			hubo[idx]--;
			hubo[1]++;
			cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean check() {
		for(int i=2; i<=N; i++) {
			if(hubo[1] <= hubo[i])
				return true;
		}
		return false;
	}
	
	
}
