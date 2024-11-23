package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No25757_임스와함께하는미니게임 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		String type = st.nextToken();
		
		Set<String> names = new HashSet<>();
		for(int i=0; i<N; i++) {
			names.add(br.readLine());
		}

		int gameMember = 3;
		
		if(type.equals("Y")) {
			gameMember = 1;
		} else if(type.equals("F")) {
			gameMember = 2;
		}
		
		System.out.println(names.size() / gameMember);
	}

}
