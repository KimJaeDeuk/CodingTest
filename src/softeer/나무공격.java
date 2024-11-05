package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무공격 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Queue<Integer>> map = new HashMap<>();
		
		for(int i=1; i<=n; i++) {
			Queue<Integer> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					queue.add(j);
				}
			}
			map.put(i, queue);
		}
		
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			for(int j=l; j<=r; j++) {
				map.get(j).poll();
			}
		}
		int cnt = 0;
		
		for(int key : map.keySet()) {
			cnt += map.get(key).size();
		}
		System.out.println(cnt);

	}

}


/*
1 - 5일경우
0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1


4 - 8 일경우

0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1


근데 답이 54


*/