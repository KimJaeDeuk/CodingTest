package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무섭지 {
	static class Node{
		int x;
		int y;
		int turn = 0;
		Node(int x, int y, int turn) {
			this.x = x;
			this.y = y;
			this.turn = turn;
		}
	}
	static int[] nx = {0,0,-1,1};
	static int[] ny = {1,-1,0,0};
	static char[][] arr;
	static boolean visited[][];
	static ArrayList<Node> ghostList = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M];
		Queue<Node> queue = new LinkedList<>();
		int doorX = 0, doorY = 0;
		for(int i=0 ;i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				char c = str.charAt(j);
				arr[i][j] = c;
				if(c=='G') {
					ghostList.add(new Node(i,j,0));
				} else if(c=='N') {
					queue.add(new Node(i,j,0));
					visited[i][j] = true;
				} else if(c=='D') {
					doorX = i;
					doorY = j;
				}
			}
		}
		boolean check = false;
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			if(node.x == doorX && node.y == doorY) {
				int turn = node.turn; // 몇턴을 움직였는지
				
				if(ghostList.size() == 0 ) {
					check = true;
					break;
				} else {
					boolean ghostCheck = false;
					for(Node ghost : ghostList) {
						
						int gx = ghost.x;
						int gy = ghost.y;
						
						int xDiff = Math.abs(gx-doorX);
						int yDiff = Math.abs(gy-doorY);
						
						if(xDiff+yDiff <= turn) {
							ghostCheck = true;
						}
						
					}
					if(ghostCheck) {
						check = false;
					} else {
						check = true;
						break;
					}
				}
				
			}
			
			for(int k=0; k<4; k++) {
				int dx = nx[k] + node.x;
				int dy = ny[k] + node.y;
				
				if(dx < 0 || dy < 0 || dx>=N || dy>=M || visited[dx][dy] || arr[dx][dy] == '#') continue;
				
				queue.add(new Node(dx,dy, node.turn + 1));
				visited[dx][dy] = true;
			}
			
		}
		
		if(check) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
