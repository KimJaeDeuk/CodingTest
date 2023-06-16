package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11047_동전0 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = 0;
		int idx = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int coin[] = new int[N];
		
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			if(coin[i]<=K) {
				idx = i;
				max = coin[i];
			}
		}
		int cnt = 0;
		for(int i=idx; i>=0; i--) {
			
			int n = K/coin[i];
			cnt+=n;
			
			K = K%coin[i];
			if(K==0)
				break;
		}
		System.out.println(cnt);

	}

}
