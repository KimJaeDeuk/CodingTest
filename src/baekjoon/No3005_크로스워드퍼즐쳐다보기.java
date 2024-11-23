package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No3005_크로스워드퍼즐쳐다보기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<String> words = new PriorityQueue<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] cross = new char[R][C];
		
		for(int i=0; i<R; i++) {
			cross[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			
			String[] line = new String(cross[i]).split("#");
			for(String s : line) {
				if(s.length()>1) {
					words.add(s);
				}
			}
		}
		
		for(int i=0; i<C; i++) {
			StringBuilder word = new StringBuilder();
			
			for(int j=0; j<R; j++) {
				word.append(cross[j][i]);
			}
			String[] line = word.toString().split("#");
			for(String s : line) {
				if(s.length()>1) {
					words.add(s);
				}
			}
		}
		System.out.println(words.poll());
	}

}
