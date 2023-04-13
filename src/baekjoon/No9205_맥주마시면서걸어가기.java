package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
	int type;
	int x;
	int y;
	int drink = 20;
	public Position(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	
}


public class No9205_맥주마시면서걸어가기 {
	static StringBuffer sb = new StringBuffer();
	static boolean can = false;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			
			int cs = Integer.parseInt(br.readLine());
			
			Position[] list = new Position[cs+2];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list[0] = new Position(0,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i=1; i<cs+1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				list[i] = new Position(1,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine(), " ");
			list[cs+1] = new Position(2,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
			bfs(list);
			
			
			if(can) {
				sb.append("happy").append("\n");
			}else {
				sb.append("sad").append("\n");
			}
			
			can = false;
			
		}
		System.out.println(sb);
	}
	private static void bfs(Position[] list) {
		Queue<Position> queue = new LinkedList<Position>();
		boolean visited[] = new boolean[list.length];
		queue.add(list[0]);
		visited[0] = true;
		boolean canGo = false;
		while(!queue.isEmpty()) {
			
			Position p = queue.poll();
			int now_x = p.x;
			int now_y = p.y;
			
			for(int i=1; i<list.length; i++) {
				if(list[i].x == now_x && list[i].y == now_y) continue;
				Position next_p = list[i];
				int next_x = next_p.x;
				int next_y = next_p.y;
				int dist =  Math.abs(next_x-now_x) + Math.abs(next_y-now_y) ;
				//System.out.printf("\n(%d,%d)에서 (%d,%d)까지의 거리 : %d ",now_x,now_y,next_x,next_y,dist);
				if(!visited[i] && Math.abs(next_x-now_x) + Math.abs(next_y-now_y) <= 1000) {
					queue.add(next_p);
					visited[i] = true;
					if(i==list.length-1) {
						//System.out.println(canGo);
						canGo = true;
						break;
					}
				}
				
				
			}
			
			if(canGo) {
				can = true;
				break;
			}
			
		}
		
	}


//	private static void dfs(int depth, Position[] list, ArrayList<Integer> out, boolean[] visited, int totalDepth) {
//		
//		if(totalDepth == depth) {
////			System.out.println("totalDetph : " + totalDepth + "\n현재 리스트");
////			for(int i : out) {
////				System.out.print(i +" ");
////			}
////			System.out.println();
//			canGo(list, out);
//			
//			return;
//		}
//		
//		for(int i=1; i<list.length-1; i++) {
//			
//			if(!visited[i]) {
//				visited[i] = true;
//				
//				out.add(depth+1, i);
//				
//				
//				dfs(depth+1, list, out, visited, totalDepth);
//				out.remove(depth+1);
//				visited[i] = false;
//			}
//		}
//	}

	private static void canGo(Position[] list, ArrayList<Integer> out) {
		
		boolean check = true;
		for(int i=1; i<out.size(); i++) {
			Position p = list[out.get(i-1)];
			int x =p.x;
			int y= p.y;
			
			Position next = list[out.get(i)];
			int next_x = next.x;
			int next_y = next.y;
			int dist = ( Math.abs(next_x-x) + Math.abs(next_y-y) );
			//System.out.printf("\n(%d,%d)에서 (%d,%d)까지의 거리 : %d ",x,y,next_x,next_y,dist);
			if(dist  > 1000 ) {
				check = false;
				break;
			}
			
			
		}
		if(check)
			can = true;
	}

}
