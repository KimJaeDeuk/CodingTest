import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Air{
	int x;
	int y;
	int mount;
	public Air(int x, int y, int mount) {
		this.x=x;
		this.y=y;
		this.mount=mount;
	}
}

public class Main {
	
	static int R,C,T;
	static int[][] arr;
	
	static int airX;
	static int nx[] = {-1,0,1,0};
	static int ny[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		ArrayList<Air> list = new ArrayList<Air>();
		boolean add = false;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<C; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				if(num!=0 && num!=-1)
					list.add(new Air(i,j,num));
				
				if(num==-1 && !add) {
					airX = i; // 공기청정기 윗부분 고정위치
					add = true;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			list = spreadAir(list);
			
			arr = setNewArr(list);
		
			list = windCleaner();
		}
		
		int sum=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] != -1) {
					sum+=arr[i][j];
				}
			}
		}
		System.out.println(sum);
	}
	private static ArrayList<Air> windCleaner() {
		
		int upX = airX;
		int downX = airX+1;

		arr[upX-1][0] = 0;
		arr[downX+1][0] = 0;
		
		int startX = upX-1;
		int startY = 0;
		int dir = 0;
		while(arr[startX][startY]!=-1) {
			if(dir%2==0) {
				int moveX = startX+nx[dir];
				if(moveX<0 || moveX>upX) {
					dir = (dir+1)%4;
					continue;
				}
				
				if(arr[moveX][startY] == -1)
					break;
				
				arr[startX][startY] = arr[moveX][startY];
				arr[moveX][startY] = 0;
				startX = moveX;
				
			}else {
				int moveY = startY+ny[dir];
				
				if(moveY<0 || moveY>=C) {
					dir = (dir+1)%4;
					continue;
				}
				
				if(arr[startX][moveY] == -1)
					break;
				
				arr[startX][startY] = arr[startX][moveY];
				arr[startX][moveY] = 0;
				startY = moveY;
				
			}
		}
		startX = downX+1;
		startY = 0;
		dir = 2;
		while(startX!=downX || startY !=0) {
			if(dir%2==0) {
				int moveX = startX+nx[dir];
				if(moveX<downX || moveX>=R) {
					dir = (dir+3)%4;
					continue;
				}
				if(arr[moveX][startY] == -1)
					break;
				
				
				
				arr[startX][startY] = arr[moveX][startY];
				arr[moveX][startY] = 0;
				startX = moveX;
				
			}
			else {
				int moveY = startY + ny[dir];
				if(moveY < 0 || moveY>=C) {
					dir = (dir+3)%4;
					continue;
				}
				if(arr[startX][moveY] == -1)
					break;
				
				arr[startX][startY] = arr[startX][moveY];
				arr[startX][moveY] = 0;
				startY = moveY;
			
			}
		}
		ArrayList<Air> return_list = new ArrayList<Air>();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] != 0 && arr[i][j] != -1) {
					return_list.add(new Air(i,j,arr[i][j]));
				}
			}
		}
		return return_list;
	}
	private static int[][] setNewArr(ArrayList<Air> list) {
		int[][] new_arr = new int[R][C];
		
		for(Air a : list) {
			new_arr[a.x][a.y]+=a.mount; 
		}
		new_arr[airX][0] = -1;
		new_arr[airX+1][0] = -1;
		
		return new_arr;
		
	}
	private static ArrayList<Air> spreadAir(ArrayList<Air> list) {
		ArrayList<Air> spread = new ArrayList<Air>();
		
		boolean []dir;
		for(int i=0; i<list.size(); i++) {
			Air a = list.get(i);
			dir = new boolean[4];
			int qx = a.x;
			int qy = a.y;
			int qmount = a.mount;
			int cnt = 0;
			
			for(int k=0; k<4; k++) {
				int dx = nx[k] + qx;
				int dy = ny[k] + qy;
				
				if(dx<0 || dy<0 || dx>=R || dy>=C || arr[dx][dy]==-1) continue;
				
				
				cnt++;
				dir[k] = true;
			}
			
			
			spread.add(new Air(qx,qy, qmount - ((qmount/5) * cnt)));
			for(int k=0; k<4; k++) {
				if(dir[k]) {
					int dx = nx[k] + qx;
					int dy = ny[k] + qy;
					int mount = qmount/5;
					if(mount!=0)
						spread.add(new Air(dx,dy,mount));
				}
			}
		}
		return spread;
		
	}

}
