package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No20301_반전요세푸스 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N, K, M;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		int move = 0;
		int reverse = 0;
		boolean normal = true;
		int idx = -1;
		
		StringBuilder sb = new StringBuilder();
		
		
		while(list.size()>0) {
				if(normal) {
					idx = (idx+1)%list.size();
				}else {
					idx = (list.size() + idx -1)%list.size();
				}
			move++;
			
			
			if(move!=0 && move%K==0) {
				sb.append(list.remove(idx)).append("\n");
				reverse++;
				if(normal)
					idx = idx-1;
				
				if(reverse!=0 && reverse%M==0) {
					if(normal) {
						idx = idx+1;
					}else {
						idx = idx-1;
					}
					normal = !normal;
					reverse = 0;
				}
			
			}
			
			
		}
		System.out.println(sb);
		

	}

}

// 1 2 3 4 5 6 7			idx = 0, remove 1, revesre = 1
// |1|						idx = 1, remove 2, reverse = 1
// 1 |2|				    idx = 2, remove 3, reverse = 1
// 1 2 4 5 6 7  // 	[ 3 ,  	idx = 3, remove 3, reverse = 2
// 1 2 |4| 5 6 7	[ 3 ,   idx = 3, remove 4, reverse = 2
// 1 2 4 |5| 6 7	[ 3,	idx = 4, remove 5, reverse = 2
// 1 2 4 5 7	[3,6		idx = 5, remove 6, 
