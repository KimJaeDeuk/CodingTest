import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<int[]> list = new ArrayList<>();

            int[][] arr = new int[N+1][2];
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            list = check(list, 0);

            list = check(list, 1);

            sb.append(list.size()).append("\n");
        }
        System.out.print(sb);
    }

    private static ArrayList<int[]> check(ArrayList<int[]> list, int idx) {
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[idx] - o2[idx];
            }
        });
        int[] firstArr = list.get(0);

        int i = 1;
        int size = list.size();
        ArrayList<int[]> nextList = new ArrayList<>();
        nextList.add(firstArr);
        while(i < size) {// 1 8 2 7
            int[] next = list.get(i);
            i++;
            if(firstArr[0] < next[0] && firstArr[1] < next[1]) {
                continue;
            }
            firstArr = next;
            nextList.add(next);
        }
        return nextList;
    }
}
