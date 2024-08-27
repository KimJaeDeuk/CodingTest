import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Num{
	int num;
	int cnt;
	public Num(int n, int c) {
		this.num = n;
		this.cnt = c;
	}
	
	
}
public class Main {
	
	static int r, c, k;
	
	static int rowSize = 3;
	static int colSize = 3;
	public static void main(String[] args) throws Exception{
		int[][] arr = new int[101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		
		while(true) {
			
			if(arr[r][c]==k) {
				System.out.println(time);
				return;
			}
			if(time==100) {
				System.out.println(-1);
				return;
			}
			if(rowSize>=colSize) {
				increaseColSize(arr);
			}else {
				increaseRowSize(arr);
			}
			time++;
		}
		
	}
	// 열 가로
	private static void increaseRowSize(int[][] arr) {
		HashMap<Integer, Integer> map;
		PriorityQueue<Num> queue = new PriorityQueue<>(new Comparator<Num>() {
			
			public int compare(Num n1, Num n2) {
				if(n1.cnt==n2.cnt) {
					return Integer.compare(n1.num, n2.num);
				}else {
					return Integer.compare(n1.cnt, n2.cnt);
				}
			}
		});
		int max = 0;
		for(int i=0; i<colSize; i++) {
			map = new HashMap<Integer,Integer>();
			
			for(int j=0; j<rowSize; j++) {
				int n = arr[j][i];
				if(n==0) continue;
				if(!map.containsKey(n)) {
					map.put(n, 1);
					
				}else {
					map.put(n, map.get(n)+1);
				}
			}
			max = Math.max(map.size()*2, max);
			for(int num : map.keySet()) {
				queue.add(new Num(num, map.get(num)));
			}
			int idx=0;
			while(!queue.isEmpty()) {
				Num n = queue.poll();
				arr[idx][i] = n.num;
				arr[idx+1][i] = n.cnt;
				idx+=2;
			}
			
			for(int j=map.size()*2; j<101; j++) {
				arr[j][i] = 0;
			}
		}
		rowSize = max;
		if(rowSize>=101) rowSize = 100;
		
	}
	// 행 세로
	private static void increaseColSize(int[][] arr) {
		HashMap<Integer, Integer> map;
		PriorityQueue<Num> queue = new PriorityQueue<>(new Comparator<Num>() {
			
			public int compare(Num n1, Num n2) {
				if(n1.cnt==n2.cnt) {
					return Integer.compare(n1.num, n2.num);
				}else {
					return Integer.compare(n1.cnt, n2.cnt);
				}
			}
		});
		int max = 0;
		for(int i=0; i<rowSize; i++) {
			map = new HashMap<Integer,Integer>();
			
			for(int j=0; j<colSize; j++) {
				int n = arr[i][j];
				if(n==0) continue;
				
				if(!map.containsKey(n)) {
					map.put(n, 1);
					
				}else {
					map.put(n, map.get(n)+1);
				}
			}
			max = Math.max(map.size()*2, max);
			for(int num : map.keySet()) {
				queue.add(new Num(num, map.get(num)));
			}
			int idx=0;
			while(!queue.isEmpty()) {
				Num n = queue.poll();
				arr[i][idx] = n.num;
				arr[i][idx+1] = n.cnt;
				idx+=2;
			}
			
			for(int j=map.size()*2; j<101; j++) {
				arr[i][j] = 0;
			}
		}
		colSize = max;
		if(colSize>=101) colSize = 100;
		
	}

}
