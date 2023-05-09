package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20057_마법사상어와토네이도 {
	static int N;
	static int arr[][];
	static int dir = 0;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {-1,0,1,0};
	static int sx[] = {-1, -1, 1, 1};
	static int sy[] = {1,-1,-1,1};
	static int nowX, nowY;
	static int total = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nowX = N/2;
		nowY = N/2;
		arr = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int print = 1;
		for(int i=0; i<N; i++) {

			for(int j=0; j<print; j++) {
				int nx = dx[dir] + nowX;
				int ny = dy[dir] + nowY;
				
				nowX = nx;
				nowY = ny;
				spreadSand();
				//System.out.println( nx + " " + ny);
				
				if(nx==0 && ny==0) {
					System.out.println(total);return;}
			}
			
			dir = (dir+1)%4;
			

			for(int j=0; j<print; j++) {
				int nx = dx[dir] + nowX;
				int ny = dy[dir] + nowY;
				
				nowX = nx;
				nowY = ny;
				spreadSand();
				//System.out.println( nx + " " + ny);
				
			}
			print++;
			dir = (dir+1)%4;
		}

	}
	
	private static void spreadSand() {
		
		int fiveX = dx[dir]*2 + nowX;
		int fiveY = dy[dir]*2 + nowY;
		int sandTotal=0;
		sandTotal = setSandTotal();
		if(check(dx[dir]+nowX, dy[dir]+nowY)) {
			arr[dx[dir]+nowX][dy[dir]+nowY] = arr[nowX][nowY] - sandTotal;
		}else {
			total += sandTotal;
		}
		if(check(fiveX, fiveY)) {
			arr[fiveX][fiveY] += ((arr[nowX][nowY] * 5) / 100);
		}else {
			total += arr[nowX][nowY] * 5 / 100;
		}
		
		for(int i=-1; i<=2; i+=2) {
			if(dir%2==0) {
				int tenAndOneAndSevenx = nowX + i;
				int tenY = nowY + dy[dir];
				int oneY = nowY + dy[(dir+2)%4];
				int sevenAndTwoY = nowY;
				int twoX = nowX + i*2;
				if(check(tenAndOneAndSevenx, tenY)) {
					arr[tenAndOneAndSevenx][tenY] += arr[nowX][nowY] * 10 / 100;
				}else {
					total += arr[nowX][nowY] * 10 / 100;
				}
				if(check(tenAndOneAndSevenx, oneY)) {
					arr[tenAndOneAndSevenx][oneY] += arr[nowX][nowY] * 1 / 100;
				}else {
					total += arr[nowX][nowY] * 1 / 100;
				}
				if(check(tenAndOneAndSevenx, sevenAndTwoY)) {
					arr[tenAndOneAndSevenx][sevenAndTwoY] += arr[nowX][nowY] * 7 / 100;
				}else {
					total += arr[nowX][nowY] * 7 / 100;
				}
				if(check(twoX, sevenAndTwoY)) {
					arr[twoX][sevenAndTwoY] += arr[nowX][nowY] * 2 / 100;
				}else {
					total += arr[nowX][nowY] * 2 / 100;
				}
			}else {
				int tenX = nowX + dx[dir];
				int oneX = nowX + dx[(dir+2)%4];
				int tenAndOneAndSevenY = nowY + i;
				int sevenAndTwoX = nowX;
				int twoY = nowY + i*2;
				
				if(check(tenX, tenAndOneAndSevenY)) {
					arr[tenX][tenAndOneAndSevenY] += arr[nowX][nowY] * 10 / 100;
				}else {
					total += arr[nowX][nowY] * 10 / 100;
				}
				if(check(oneX, tenAndOneAndSevenY)) {
					arr[oneX][tenAndOneAndSevenY] += arr[nowX][nowY] * 1 / 100;
				}else {
					total += arr[nowX][nowY] * 1 / 100;
				}
				if(check(sevenAndTwoX, tenAndOneAndSevenY)) {
					arr[sevenAndTwoX][tenAndOneAndSevenY] += arr[nowX][nowY] * 7 / 100;
				}else {
					total += arr[nowX][nowY] * 7 / 100;
				}
				if(check(sevenAndTwoX, twoY)) {
					arr[sevenAndTwoX][twoY] += arr[nowX][nowY] * 2 / 100;
				}else {
					total += arr[nowX][nowY] * 2 / 100;
				}
			}
			
			
		}
		arr[nowX][nowY] = 0; 
		System.out.println("----------------");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------- total : " + total + " \n");
		
	}
	private static int setSandTotal() {
		int sandTotal=0;
		sandTotal += ((arr[nowX][nowY] * 5) / 100);
		sandTotal += ((arr[nowX][nowY] * 10) / 100);
		sandTotal += ((arr[nowX][nowY] * 10) / 100);
		sandTotal += ((arr[nowX][nowY] * 1) / 100);
		sandTotal += ((arr[nowX][nowY] * 1) / 100);
		sandTotal += ((arr[nowX][nowY] * 7) / 100);
		sandTotal += ((arr[nowX][nowY] * 7) / 100);
		sandTotal += ((arr[nowX][nowY] * 2) / 100);
		sandTotal += ((arr[nowX][nowY] * 2) / 100);
		return sandTotal;
	}
	private static boolean check(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N) {
			return false;
		}
		return true;
	}
}

/*
 * (3,3) !(3,2)!,  (4,2) , (4,3) , !(4,4)!, 3,4, !(2,4)! 2,3 2,2, !(2,1)!
 * 
 * */
