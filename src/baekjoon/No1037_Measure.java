package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1037_Measure {
	static int T;
	static ArrayList<Integer> N;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		N = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<T; i++)
			N.add(Integer.parseInt(st.nextToken()));
		
		System.out.println(getRealMeasure());
	}

	private static int getRealMeasure() {
		// TODO Auto-generated method stub
		return Collections.max(N) * Collections.min(N);
	}

}
