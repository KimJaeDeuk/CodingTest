package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv3_아이템줍기 {

	public static void main(String[] args) {
		int[][] rectangle = new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
		int x1 = 1;
		int x2 =3;
		int y1 = 7;
		int y2 = 8;
		int answer = solution(rectangle, x1,x2,y1,y2); 
		System.out.println(answer);
	}
	
	
	 public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
	        int answer = 0;
	        int map[][] = new int[11][11];
	        for(int i=0; i<rectangle.length; i++) {
	            
	            int x1 = rectangle[i][0];
	            int y1 = rectangle[i][1];
	            int x2 = rectangle[i][2];
	            int y2 = rectangle[i][3];
	            
	            for(int x = x1; x<=x2; x++) {
	                map[x][y1] = 1;
	                map[x][y2] = 1;
	            }
	            for(int y = y1; y<=y2; y++) {
	                map[x1][y] = 1;
	                map[x2][y] = 1;
	            }
	            
	        }
	        
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[]{0, 0});
	        boolean visited[][] = new boolean[11][11];
	        visited[0][0] = true;
	        
	        int[] dx = {1,1,0,-1,-1,-1,0,1};
	        int[] dy = {0,1,-1,0,1,-1,1,-1};
	        while(!queue.isEmpty()) {
	            int[] now = queue.poll();
	            
	            for(int i=0; i<8; i++) {
	                
	                int nx = dx[i] + now[0];
	                int ny = dy[i] + now[1];
	                
	                if(nx < 0 || ny < 0 || nx>=11 || ny>=11 || visited[nx][ny]) continue;
	                
	                if(map[nx][ny] == 1) {
	                    map[nx][ny] = 2;
	                    
	                }
	                if(map[nx][ny] == 0 ) {
	                    queue.add(new int[]{nx,ny});
	                }
	                visited[nx][ny] = true;
	                
	            }
	        }
	        for(int i=0; i<11; i++) {
	        	for(int j=0; j<11; j++) {
	        		System.out.print(map[i][j] +" ");
	        	}
	        	System.out.println();
	        }
	        queue = new LinkedList<>();
	        visited = new boolean[51][51];
	        queue.add(new int[]{characterX, characterY, 0});
	        visited[characterX][characterY] = true;
	        dx = new int[]{0,0, -1, 1};
	        dy = new int[]{1,-1, 0, 0};
	        int min = Integer.MAX_VALUE;
	        while(!queue.isEmpty()) {
	            int[] now = queue.poll();
	            
	            if(now[0] == itemY && now[1] == itemX) {
	                min = Math.min(min, now[2]);
	            }
	            
	            for(int i=0; i<4 ; i++) {
	                int nx = dx[i] + now[0];
	                int ny = dy[i] + now[1];
	                
	                if(nx < 0 || ny < 0 || nx>=11 || ny>=11 || visited[nx][ny] || map[nx][ny] != 2) continue;
	                
	                visited[nx][ny] = true;
	                
	                queue.add(new int[] {nx, ny, now[2]+1});
	                
	                
	            }
	        }
	        
	        answer = min;
	        
	        return answer;
	    }
}
