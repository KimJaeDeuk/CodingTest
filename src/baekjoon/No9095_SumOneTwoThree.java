package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095_SumOneTwoThree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		int[] cnt = new int[15];
		cnt[1] = 1;
		cnt[2] = 2;
		cnt[3] = 4;
		
		
		for(int i=4; i<11; i++) {
			cnt[i] = cnt[i-1] + cnt[i-2] + cnt[i-3];
		}
		for(int i=0; i<T; i++) {
			sb.append(cnt[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}

}
