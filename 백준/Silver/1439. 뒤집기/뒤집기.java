import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();


        boolean flag = str.charAt(0) == '1';
        // false 일때는 0 true일때는 1
        int zeroCnt = 0;
        int oneCnt = 0;

        if(flag) {
            oneCnt++;
        } else {
            zeroCnt++;
        }

        for(int i=0; i<str.length(); i++) {

            if(str.charAt(i)=='0' && flag) {
                flag = false;
                zeroCnt++;
            }
            if(str.charAt(i) == '1' && !flag) {
                flag= true;
                oneCnt++;
            }
        }

        System.out.println(zeroCnt < oneCnt ? zeroCnt : oneCnt);
    }
}
