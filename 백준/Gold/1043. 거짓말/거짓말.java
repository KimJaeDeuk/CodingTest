import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int truePeople = Integer.parseInt(st.nextToken());
		
		if(truePeople == 0) {
			System.out.println(M);
			System.exit(0);
		}
		boolean visited[] = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<truePeople; i++) {
			int num = Integer.parseInt(st.nextToken());
			queue.add(num);
			visited[num] = true;
		}
		ArrayList<ArrayList<Integer>> list =new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			list.add(new ArrayList<>());
			for(int j=0; j<num; j++) {
				int pNum = Integer.parseInt(st.nextToken());
				list.get(i).add(pNum);
			}
		}
		
		while(!queue.isEmpty()) {
			
			int num = queue.poll();
			
			for(int i= list.size()-1; i>=0 ;i--) {
				ArrayList<Integer> li = list.get(i);
				
				if(li.indexOf(num) != -1) {
					for(int value : li) {
						if(!visited[value]) {
							queue.add(value);
							visited[value] = true;
						}
					}
					
					list.remove(i);
				}
			}
		}

		System.out.println(list.size());
		
	}
	
	
}
