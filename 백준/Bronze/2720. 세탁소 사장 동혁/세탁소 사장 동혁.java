import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int QUARTER = 25;
    static final int DIME = 10;
    static final int NICKEL = 5;
    static final int PENNY = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-->0) {

            int n = Integer.parseInt(br.readLine());
            int quarterCnt = n/QUARTER;
            n -= quarterCnt * QUARTER;
            int dimeCnt = n/DIME;
            n -= dimeCnt * DIME;
            int nickelCnt = n/NICKEL;
            n -= nickelCnt * NICKEL;
            int pennyCnt = n/PENNY;
            n -= pennyCnt * PENNY;

            sb.append(quarterCnt).append(" ").append(dimeCnt).append(" ").append(nickelCnt).append(" ").append(pennyCnt).append("\n");

        }
        System.out.println(sb);
    }
}
