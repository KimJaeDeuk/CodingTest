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
    static int R, C;
    static int[] nx = {-1, 0, 1};
    static int[] ny = {1, 1, 1};
    static char[][] map;
    static int cnt = 0;
    static boolean into;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<R; i++) {
            into = false;
            dfs(i,0);
        }

        System.out.println(cnt);

    }

    private static void dfs(int curX, int curY) {
        if (curY == C-1 && !into) {
            cnt++;
            into = true;
            return;
        }
        boolean check = false;
        for(int i=0; i<3; i++) {
            int dx = curX + nx[i];
            int dy = curY + ny[i];

            if(dx <0 || dx>=R || dy>=C || map[dx][dy] == 'x') {
                continue;
            }
            map[dx][dy] = 'x';
            dfs(dx, dy);

            if(into) {
                return ;
            }
        }
    }

}
