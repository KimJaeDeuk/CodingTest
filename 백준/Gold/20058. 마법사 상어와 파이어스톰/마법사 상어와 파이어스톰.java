import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// No.20058
public class Main {

	static StringBuilder result = new StringBuilder();
	static int N, Q;
	static int[][] arr;
	static int height;
	static int[] nx = {0,0,-1,1};
	static int[] ny = {1,-1,0,0};
	static class Node{
		int x;
		int y;
		int cnt;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		height = (int)Math.pow(2,N);
		arr = new int[height][height];

		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<height; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		// 1 마법 레벨 측정

		for(int i=1; i<=Q; i++) {
			int level = Integer.parseInt(st.nextToken());
			// 2 2의 마법레벨 측정사이즈를 우측으로 90도 회전
			rotateArr(level);
			// 3 3개이상의 얼음과 인접하지않은 경우 얼음양 -1
			check(new boolean[height][height], i*-1);

		}

		int[] result = getSumArea();
		StringBuilder sb = new StringBuilder();
		sb.append(result[0]).append("\n").append(result[1]);
		System.out.println(sb);
	}

	private static int[] getSumArea() {
		int[] result = new int[2];
		int sum = 0;
		int max = 0;

		boolean visited[][] = new boolean[height][height];
		for(int i=0; i<height; i++) {
			for(int j=0 ;j<height; j++) {
				if(arr[i][j] > 0 ) {
					sum+=arr[i][j];
					if(!visited[i][j]) {
						max = Math.max(max, checkArea(visited, i, j));
					}
				}
			}
		}
		result[0] = sum;
		result[1] = max;
		return result;
	}

	private static int checkArea(boolean[][] visited, int i, int j) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i, j));
		visited[i][j] = true;
		int size = 1;
		while(!queue.isEmpty()) {

			Node node = queue.poll();

			for(int k=0;k<4; k++) {
				int dx = node.x + nx[k];
				int dy = node.y + ny[k];

				if(dx < 0 || dy < 0 || dx >= height || dy >= height || visited[dx][dy] || arr[dx][dy] <= 0) {
					continue;
				}

				size++;
				queue.add(new Node(dx, dy));
				visited[dx][dy] = true;
			}
		}
		return size;
	}

	private static void check(boolean[][] visited, int time) {

		for(int i=0; i<height; i++) {
			for(int j=0; j<height; j++) {
				if (arr[i][j] > 0  && !visited[i][j]) {
					bfs(i, j, visited, time);
				}
			}
		}

	}

	private static void bfs(int i, int j, boolean[][] visited, int time) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i,j));
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			Node curr_node = queue.poll();
			int curr_x = curr_node.x;
			int curr_y = curr_node.y;
			int cnt = 0;
			for(int k=0; k<4; k++) {
				int dx = curr_x + nx[k];
				int dy = curr_y + ny[k];

				if(dx <0 || dy < 0 || dx>=height || dy>=height || (arr[dx][dy] <= 0 && arr[dx][dy] > time)) {
					continue;
				}
				if(arr[dx][dy] != 0 || arr[dx][dy] == time ) {
					cnt++;
				}
				if (!visited[dx][dy]) {
					queue.add(new Node(dx,dy));

					visited[dx][dy] = true;
				}
			}
			if(cnt< 3) {
				if(--arr[curr_x][curr_y] == 0) {
					arr[curr_x][curr_y] = time;
				}

			}

		}
	}

	private static void rotateArr(int level) {
		if(level == 0) return;

		int area = (int)Math.pow(2,level);
		for(int i=0; i<height; i += area) {

			for(int j=0; j<height; j += area) {
				changeValue(i, j, area);

			}

		}
	}
	private static void changeValue(int a, int b, int area) {
		int[][] newArr = new int[height][height];


		for(int i=0; i<area; i++) {

			for(int j=0; j<area; j++) {
				newArr[a+j][b+area-i-1] = arr[i+a][j+b];
			}

		}
		for(int i=a; i<area+a; i++) {
			for(int j=b; j<area+b; j++) {
				arr[i][j] = newArr[i][j];
			}
		}

	}

}