package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No5430_AC {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC  =Integer.parseInt(br.readLine());
		
		while(TC-->0) {
			String method = br.readLine();
			int cnt = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			
			sb.append(getResult(method,cnt,arr)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static String getResult(String method, int cnt, String arr) {
		System.out.println(method + " " + arr);
		List<String> list = new ArrayList<>(Arrays.asList(arr.substring(1,arr.length()-1).split(",")));
		
		for(int i=0; i<method.length(); i++) {
			if(method.charAt(i)=='D') {
				if(cnt==0) System.out.println(list.size());
				if(list.size()==0) {
					return "error";
				}
				list.remove(0);
			}else if(method.charAt(i)=='R') {
				if(list.size()!=0) {
					Collections.reverse(list);
				}
			}
			
		}
		
		return list.toString();
	}

	

}
