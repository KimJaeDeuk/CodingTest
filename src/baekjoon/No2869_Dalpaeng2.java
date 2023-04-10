package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2869_Dalpaeng2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());

		int B = Integer.parseInt(st.nextToken());

		int V = Integer.parseInt(st.nextToken());
		int cnt = (V-B) / (A-B);
		if((V-B) % (A-B) !=0) 
			cnt++;
		System.out.println(cnt);
	}

}
