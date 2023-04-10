package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No2161_Card1 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> num_list = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++)
			num_list.add(i);
		ArrayList<Integer> trash_list = new ArrayList<Integer>();
		while(num_list.size()>1) {
			
			trash_list.add(num_list.remove(0));
			
			num_list.add(num_list.remove(0));
			
			
		}
		
		for(int i : trash_list) {
			System.out.print(i+" ");
		}
		System.out.print(num_list.get(0));
	}

}
