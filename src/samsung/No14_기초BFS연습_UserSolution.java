package samsung;

import java.util.ArrayList;

public class No14_기초BFS연습_UserSolution {
	private int N;
	private int map[][];
	private static final int dx[] = {-1,1,0,0};
	private static final int dy[] = {0,0,-1,1};
	
	public class Node{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	
    void bfs_init(int map_size, int map[][]) {
    	this.map = new int[map_size+1][map_size+1];
    	
    	this.N = map_size;
    	
    	for(int i=0; i<this.N; i++) {
    		for(int j=0; j<this.N; j++) {
    			this.map[i+1][j+1] = map[i][j];
    			if(map[i][j]==0) {
    				
    			}
    		}
    	}
    	
    }

    int bfs(int x1, int y1, int x2, int y2) {
    	int[][] queue = new int[N*N][3];
    	int head = 0;
    	int poll = 0;
    	queue[head++] = new int[]{x1,y1,0};
    	
    	boolean[][] visited = new boolean[this.N+1][this.N+1];
    	
    	visited[y1][x1] = true;
    	int result = -1;
    	while(queue[poll][0]!=0) {
    		int[] q = queue[poll++];
    		
    		int qx = q[0];
    		int qy = q[1];
    		int qCnt = q[2];
    		if(qx==x2 && qy==y2) {
    			return qCnt;
    		}
    		for(int k=0; k<4; k++) {
    			int nx = dx[k] + qx;
    			int ny = dy[k] + qy;
    			
    			if(nx < 1 || ny < 1 || nx > N || ny > N || visited[ny][nx] || map[ny][nx]==1) {
    				continue;
    			}
    			
    			visited[ny][nx] = true;
    			queue[head++] = new int[] {nx,ny,qCnt+1};
    		}
    		
    	}
    	
    	
    	
    	return result;
    }	
}
