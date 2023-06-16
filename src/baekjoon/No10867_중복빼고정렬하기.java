package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No10867_중복빼고정렬하기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int num;
		for(int i=0; i<N; i++) {
			 num = Integer.parseInt(st.nextToken());
			 if(!list.contains(num)) {
				 list.add(num);
			 }
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int a : list)
			sb.append(a).append(" ");
		System.out.println(sb);
	}

}
