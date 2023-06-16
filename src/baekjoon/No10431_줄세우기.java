package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No10431_줄세우기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			int n = Integer.parseInt(st.nextToken());
			int cnt = 0;
			sb.append(n).append(" ");
			for(int i=0; i<20 ;i++) {
				int num = Integer.parseInt(st.nextToken());
				boolean check = false;
				for(int j=0; j<list.size(); j++) {
					if(list.get(j) > num) {
						cnt += list.size() - (j);
						list.add(j, num);
						check = true;
						break;
					}
				}
				if(!check) {
					list.add(num);
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
