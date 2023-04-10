package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No11866_Yosepuse {//TODO : 요세푸스 수열 풀어야함

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt( st.nextToken());
		int K = Integer.parseInt( st.nextToken());
		int sum=0;
		int cnt = 0;
		ArrayList<Integer> list_cnt = new ArrayList<Integer>();
		for(int i=0; i<N; i++)
			list_cnt.add(i+1);
		ArrayList list = new ArrayList<>();
		int exist = 0;
		while(cnt<N) {
			
			for(int a=0; a<list_cnt.size(); a++) {
				if(a!=0) {
					exist++;
				}
				if(exist==K) {
					//list_cnt.
					list.add(list_cnt.get(a));
					exist=0;
					cnt++;
					break;
				}
			}
			
		}
		//for(int i=0; i<)
		System.out.println(list);
		
	}

}
