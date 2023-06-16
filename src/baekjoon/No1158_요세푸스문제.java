package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1158_요세푸스문제 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=N; i++)
			list.add(i);
		int a=0;
		int index=K-1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(true) {
			int num = list.get(index);
			result.add(num);
			list.remove(index);
			
			if(list.isEmpty()) break;
			index = (index+K-1)%list.size();
			a++;
		}
		for(int i=0; i< result.size(); i++) {
			if(i!=result.size()-1)
				sb.append(result.get(i)+", ");
			else {
				sb.append(result.get(i));
			}
		}
		
		sb.append(">");
		
		System.out.println(sb);

	}

}
