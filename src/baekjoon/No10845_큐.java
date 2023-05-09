package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No10845_큐 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String operator = st.nextToken();
			if(operator.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				
				list.add(num);
			}else if(operator.equals("pop")) {
				if(list.size()==0) {
					sb.append("-1").append("\n");
				}else {
					sb.append(list.get(0)).append("\n");
					list.remove(0);
				}
			}else if(operator.equals("size")) {
				sb.append(list.size()).append("\n");
			}else if(operator.equals("empty")) {
				if(list.size()==0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(operator.equals("front")) {
				if(list.size()==0) {
					sb.append(-1).append("\n");
				}else
					sb.append(list.get(0)).append("\n");
			}else if(operator.equals("back")) {
				if(list.size()==0) {
					sb.append(-1).append("\n");
				}else
					sb.append(list.get(list.size()-1)).append("\n");
			}
			
			
			
		}
		System.out.println(sb);

	}

}
