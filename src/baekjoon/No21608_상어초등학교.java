package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
class Seat{
	int x;
	int y;
	int max;
	public Seat(int x, int y, int max) {
		this.x = x;
		this.y = y;
		this.max = max;
	}
	
}
public class No21608_상어초등학교 {
	static HashMap<Integer,ArrayList<Integer>> map = new LinkedHashMap<Integer,ArrayList<Integer>>();
	static int N;
	static int arr[][];
	static int nx[] = {0,0,-1,1};
	static int ny[] = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j=0; j<4; j++)
				list.add(Integer.parseInt(st.nextToken()));
			map.put(a, list);
			if(i==0)
				arr[1][1] = a;
			else
				setSeat(a,list);
		}
		
		
		int score = getScore();
		System.out.println(score);
		
	}
	private static int getScore() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int targetNum = arr[i][j];
				int cnt = 0;
				for(int k=0; k<4; k++) {
					int dx = i+nx[k];
					int dy = j+ny[k];
					
					if(dx<0 || dy < 0 || dx>=N || dy>=N) continue;
					
					if(map.get(targetNum).contains(arr[dx][dy])) cnt++;
				}
				if(cnt!=0)
					sum += Math.pow(10, cnt-1);
			}
		}
		return sum;
	}
	private static int setSeat(int num, ArrayList<Integer> list) {
		
		//1번조건
		HashMap<Integer, ArrayList<Seat>> oneMap = new HashMap<Integer, ArrayList<Seat>>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==0) {
					int cnt = 0;
 					for(int k=0; k<4; k++) {
 						int dx = nx[k] + i;
						int dy = ny[k] + j;
						if(dx>=N || dy >=N || dx < 0 || dy < 0 || arr[dx][dy]==0) continue;
						
						if(map.get(num).contains(arr[dx][dy])) cnt++;
					}
					if(!oneMap.containsKey(cnt)) {
						oneMap.put(cnt, new ArrayList<>(Arrays.asList(new Seat(i,j,0))));
					}else {
						ArrayList<Seat> a = oneMap.get(cnt);
						a.add(new Seat(i,j,0));
 						oneMap.put(cnt, a);
					}
				}
			}
		}
		int idx = 0;
		for(int i=3; i>0; i--) {
       			if(oneMap.containsKey(i)) {
				ArrayList<Seat> check = oneMap.get(i);
				if(check.size()>1) {
					idx = i;
					break;
				}else {
					arr[check.get(0).x][check.get(0).y] = num;
					return 0;
				}
			}
		}
		
		
		//2번조건 그 중에 인접한 칸이 제일 많은 것
		ArrayList<Seat> check = oneMap.get(idx);
		HashMap<Integer, ArrayList<Seat>> twoMap = new HashMap<Integer, ArrayList<Seat>>();
		for(int i=0; i<check.size(); i++) {
			Seat s = check.get(i);
			int cnt = 0;
			for(int k=0; k<4; k++) {
 				int dx = s.x + nx[k];
  				int dy = s.y + ny[k];
				if(dx>=N || dy>=N || dx<0 || dy <0 || arr[dx][dy]!=0) continue;
				
				cnt++;
				
			}
			if(!twoMap.containsKey(cnt)) {
				twoMap.put(cnt, new ArrayList<>(Arrays.asList(new Seat(s.x,s.y,0))));
			}else {
				ArrayList<Seat> a = twoMap.get(cnt);
				a.add(new Seat(s.x,s.y,0));
				twoMap.put(cnt, a);
			}
		}
		idx = 0;
		ArrayList<Seat> twoList = null;
		for(int i=4; i>=0; i--) {
			
			if(twoMap.containsKey(i)) {
				twoList = twoMap.get(i);
				if(twoList.size()>1) {
					idx = i;
					break;
				}else if(twoList.size()==1){
					arr[twoList.get(0).x][twoList.get(0).y] = num;
					return 0;
				}
			}
		}
		
		arr[twoList.get(0).x][twoList.get(0).y] = num;
		
		return 0;
	}

}
