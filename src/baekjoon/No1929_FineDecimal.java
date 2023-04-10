package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1929_FineDecimal {

	static int M;
	static int N;
	static ArrayList<Integer> decimal_list = new ArrayList<Integer>();
	static boolean check;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());


		findDecimal();


	}

	private static void findDecimal() {
		ArrayList<Boolean> rangeInt = new ArrayList<Boolean>();

		rangeInt.add(false);
		rangeInt.add(false);
		
		for(int i=2; i <= N; i++) {
			rangeInt.add(i,true);
		}
		
		for(int i=2; (i*i) <= N; i++) {
			if(rangeInt.get(i)){
				for(int j=i*i; j<=N; j+=i) {
					rangeInt.set(j, false);
				}
			}
		}
		
		for(int i =M; i<=N; i++) {
			if(rangeInt.get(i))
				System.out.println(i);
		}
	}

}
