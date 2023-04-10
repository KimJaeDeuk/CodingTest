package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1새로운불면증치료법 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<=N; i++) {
			
			
			long cnt = Long.parseLong(br.readLine());
			
			
			
			
			int result= getResult(cnt);
			sb.append("#"+i+" " + result).append("\n");
		}
		System.out.println(sb);
	}

	private static int getResult(long cnt) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int j=0; j<10; j++)
			list.add(j);
		String value="";
		int result = 0;
		int inc=1;
		while(list.size()>0) {
			
			value = String.valueOf(cnt*(inc));
			
			for(int i=0; i<value.length(); i++) {
				if(list.size() == 0) break;
				if(list.indexOf(value.charAt(i)-'0') == -1) continue;
				list.remove(list.indexOf(value.charAt(i)-'0'));
			}
			
			result++;
			inc++;
		}
		
		
		
		return Integer.parseInt(value);
	}

}
