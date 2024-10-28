import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;

    static int[][] map;

    static int sum = 0;
    static int[][] dist = {{0,-1}, {1,0}, {0,1}, {-1, 0}};

    static int direction = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int nowX = N/2;
        int nowY = N/2;
        visited[nowX][nowY] = true;
        while(nowX != 0 || nowY != 0) {
            
            nowX = dist[direction][0] + nowX;
            nowY = dist[direction][1] + nowY;
            visited[nowX][nowY] = true;
            moveSand(nowX, nowY);

            if(changeDirection(nowX, nowY)) {
                direction = (direction+1)%4;
            }
        }
        System.out.println(sum);
    }

    private static boolean changeDirection(int nowX, int nowY) {
        int cnt = 0;
        for(int[] dir : dist) {
            int dirX = dir[0] + nowX;
            int dirY = dir[1] + nowY;

            if(dirX>=N || dirY>=N || dirX<0 || dirY<0 || !visited[dirX][dirY]) {
                cnt++;
            }
        }
        return cnt >=3;
    }

    private static void moveSand(int nowX, int nowY) {
        int nowSand = map[nowX][nowY];

        if(nowSand == 0) {
            return;
        }
        int five = (int) Math.floor(nowSand * 0.05);
        int ten = (int) Math.floor(nowSand * 0.10);
        int seven = (int) Math.floor(nowSand * 0.07);
        int two = (int) Math.floor(nowSand * 0.02);
        int one = (int) Math.floor(nowSand * 0.01);
        nowSand -= (five + ten*2 + seven*2+ two*2+one*2);
        map[nowX][nowY] = 0;
        int nextX = nowX + dist[direction][0];
        int nextY = nowY + dist[direction][1];
        // a
        checkOver(nextX, nextY, nowSand);
        // 5%
        if(five != 0) {
            checkOver(nowX + dist[direction][0]*2 , nowY + dist[direction][1]*2, five);
        }
        // 7%
        if(seven != 0) {
            checkOver(nowX + dist[(direction + 1) % 4][0], nowY + dist[(direction + 1) % 4][1], seven);
            checkOver(nowX + dist[(direction + 3) % 4][0], nowY + dist[(direction + 3) % 4][1], seven);
        }
        if(two != 0) {
            checkOver(nowX + dist[(direction + 1) % 4][0]*2, nowY + dist[(direction + 1) % 4][1]*2, two);
            checkOver(nowX + dist[(direction + 3) % 4][0]*2, nowY + dist[(direction + 3) % 4][1]*2, two);
        }
        if(ten != 0) {
            checkOver(nextX + dist[(direction + 1) % 4][0], nextY + dist[(direction + 1) % 4][1], ten);
            checkOver(nextX + dist[(direction + 3) % 4][0], nextY + dist[(direction + 3) % 4][1], ten);
        }
        if(one != 0) {
            checkOver(nowX - dist[direction][0] + dist[(direction+1)%4][0], nowY - dist[direction][1] + dist[(direction+1)%4][1], one);
            checkOver(nowX - dist[direction][0] + dist[(direction+3)%4][0], nowY - dist[direction][1] + dist[(direction+3)%4][1], one);
        }

    }

    private static void checkOver(int x, int y, int sand) {
        if(x >= 0 && x < N && y >= 0 && y < N) {
            map[x][y] += sand;
        } else {
            sum += sand;
        }

    }


}
