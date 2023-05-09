package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Fire{
	int x=0;
	int y=0;
	int m=0;
	int d=0;
	int s=0;
	int cnt = 1;
	boolean dir;
	public Fire(int x, int y,int m, int s, int d) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.s = s;
		this.d = d;
	}
	public void aaa() {
		System.out.printf("[ x : %d ] [ y : %d ] [ 질량 : %d ] [ 방향 : %d ] [ 속도 : %d ]\n", x,y,m,d,s);
	}
}

public class No20056_마법사상어와파이어볼 {
	static Fire[][] arr;
	static int N, M, K;
	static int dx[] = {-1,-1,0,1,1, 1, 0,-1};	//북 북동  동 동남 남 남서 서 북서
	static int dy[] = {0,  1,1,1,0,-1,-1,-1};
	static ArrayList<Fire> list = new ArrayList<Fire>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new Fire[N][N];
		
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Fire(r,c,m,s,d));
			arr[r][c] = new Fire(r,c,m,s,d);
		}
		for(int i=1; i<=K; i++) {
			list = moveFire(i);	// 1번조건
			arr = checkDuple();
			divisionFireball();
		}
		int sum = 0;
		for(Fire f : list) {
			sum += f.m;
		}
		System.out.println(sum);
	}
	private static void divisionFireball() {
		ArrayList<Fire> fireList = new ArrayList<Fire>();
		//2-2 조건
		for(Fire f : list) {
			if(arr[f.x][f.y].cnt>1) {
				int weight = arr[f.x][f.y].m/5;
				int speed = arr[f.x][f.y].s/arr[f.x][f.y].cnt;
				
				if(weight == 0) continue;
				
				if(arr[f.x][f.y].dir) {
					
					for(int i=1; i<8; i+=2) {
						fireList.add(new Fire(f.x,f.y,weight,speed,i));
					}
					
				}else {
					for(int i=0; i<8; i+=2) {
						fireList.add(new Fire(f.x,f.y,weight,speed,i));
					}
					
				}
				arr[f.x][f.y].cnt = 0;
			}else if(arr[f.x][f.y].cnt==1){
				fireList.add(f);
			}
		}
//		System.out.println("2-2이후 끝까지 조건 끝낸뒤");
//		for(Fire f : fireList)
//			f.aaa();
		list = fireList;
		
	}
	private static Fire[][] checkDuple() {
		Fire[][] fire_arr = new Fire[N][N];
		
		//2-1 조건
		for(Fire f : list) {
			if(fire_arr[f.x][f.y]==null) {
				fire_arr[f.x][f.y]= f;
			}else {
				fire_arr[f.x][f.y].m += f.m;
				fire_arr[f.x][f.y].s += f.s;
				fire_arr[f.x][f.y].cnt++;
				if(fire_arr[f.x][f.y].d%2!= f.d%2) {
					fire_arr[f.x][f.y].dir = true;
				}
			}
		}
		
		return fire_arr;
	}
	// m 질량  s 속력 d 방향
	private static ArrayList<Fire> moveFire(int time) {
		ArrayList<Fire> moveList = new ArrayList<Fire>();
//		System.out.println("1번 시작전");
//		for(Fire f : list)
//			f.aaa();
		for(int i=0; i<list.size(); i++) {
			
			Fire f = list.get(i);
			
			int nx = (dx[f.d]*f.s + f.x + N*1000) %N;
			int ny = (dy[f.d]*f.s + f.y + N*1000) %N;
			
			moveList.add(new Fire(nx,ny,f.m,f.s,f.d));
		}
//		System.out.println("1번 끝낸뒤");
//		for(Fire f : moveList)
//			f.aaa();
		return moveList;
	}

}
