package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bottle{
	int a;
	int b;
	int c;
	
	Bottle(int a, int b, int  c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class No2251_물통 {
	static Queue<Bottle> queue = new LinkedList<Bottle>();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int arr[] = new int[3];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		queue.add(new Bottle(0,0,arr[2]));
		list.add(arr[2]);
		bfs();
	} 
	
	private static void bfs() {
		
		while(!queue.isEmpty()) {
			
			Bottle bottle = queue.poll();
			int a = bottle.a;
			int b = bottle.b;
			int c = bottle.c;
			
			
			
		}
		
	}

}
