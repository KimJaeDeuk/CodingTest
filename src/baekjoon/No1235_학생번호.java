package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1235_학생번호 {
	static int len;
	static int N;
	static String arr[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		len = arr[0].length();
		int min = getMinK();
		System.out.println(min);
	}

	private static int getMinK() {
		ArrayList<String> list;
		for(int i=len-1; i>=0 ;i--) {
			list = new ArrayList<String>();
			boolean check = true;
			for(int j=0; j<N; j++) {
				if(list.contains(arr[j].substring(i))) {check = false; break;}
				list.add(arr[j].substring(i));
			}
			if(check) {
				return len-i;
			}
			
		}
		
		
		
		return len;
	}

}
