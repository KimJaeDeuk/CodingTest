package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No5635_Birthday {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			String name = st.nextToken();
			String d = st.nextToken();
			String M = st.nextToken();
			String Y = st.nextToken();
			d = d.length()==1 ? "0"+d : d;
			M = M.length()==1 ? "0"+M : M;
			map.put(Integer.parseInt(Y+M+d),name );
			
		}
		
		System.out.println(map.get(Collections.max(map.keySet())));
		System.out.println(map.get(Collections.min(map.keySet())));
		
	}

}
