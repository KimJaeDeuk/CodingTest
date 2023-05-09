package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No21610_마법사상어와비바라기 {
	static class Basket{
		int water;
		int cloud;
		public Basket(int w, int c) {
			this.water = w;
			this.cloud = c;
		}
	}
	static class Cloud{
		int x;
		int y;
		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static int nx[] = {0,  -1, -1, -1, 0, 1, 1,  1};
	static int ny[] = {-1, -1,  0,  1, 1, 1, 0, -1};
	static Basket[][] arr;
	static ArrayList<Cloud> list = new ArrayList<Cloud>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new Basket[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = new Basket(Integer.parseInt(st.nextToken()),0);
			}
		}
		
		for(int i=N-2; i<N; i++) {
			for(int j=0; j<2; j++) {
				list.add(new Cloud(i,j));
			}
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			moveCloud(i, dir-1, dist);
			
			waterCopyMagic();
			
			list.clear();
			createCloud(i);
		}
		int sum=0;
		
		for(int a = 0 ; a<N; a++) {
			for(int b=0; b<N; b++) {
				sum += arr[a][b].water;
			}
			
		}
		System.out.println(sum);
	}
	
	private static void createCloud(int time) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j].water>=2 && arr[i][j].cloud != time) {
					
					arr[i][j].water -=2;
					list.add(new Cloud(i,j));
				}
			}
		}
	}

	private static void moveCloud(int time, int dir, int dist) {
		
		for(int i=0; i<list.size(); i++) {
			Cloud c = list.get(i);
			
			int dx = (nx[dir]*dist + c.x + N*50)%N;
			int dy = (ny[dir]*dist + c.y + N*50)%N;
			
			c.x = dx;
			c.y = dy;
			arr[dx][dy].cloud = time;
			arr[dx][dy].water++;
			
		}
		
	}
	
	private static void waterCopyMagic() {
		
		for(int i=0; i<list.size(); i++) {
			Cloud c = list.get(i);
			int cnt = 0;
			for(int k=1; k<8; k+=2) {
				int dx = c.x + nx[k];
				int dy = c.y + ny[k];
				if(dx<0 || dy<0 || dx>=N || dy>=N || arr[dx][dy].water==0) continue;
				
				cnt++;
			}
			arr[c.x][c.y].water += cnt; 
			
		}
		
	}
}
