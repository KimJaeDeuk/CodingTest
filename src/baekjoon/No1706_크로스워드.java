package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1706_크로스워드 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];
		for(int i=0; i<R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		StringBuilder word;
		PriorityQueue<String> queue = new PriorityQueue<>();
		for(int i=0; i<R; i++) {
			
			word = new StringBuilder();
			for(int j=0; j<C; j++) {
				word.append(arr[i][j]);
			}
			String split[] = word.toString().split("#");
			for(String s : split) {
				if(s.length() > 1) {
					queue.add(s);
				}
			}
		}
		
		for(int i=0; i<C; i++) {
			word = new StringBuilder();
			for(int j=0; j<R; j++) {
				word.append(arr[j][i]);
			}
			String split[] = word.toString().split("#");
			for(String s : split) {
				if(s.length() > 1) {
					queue.add(s);
				}
			}
			
		}
		System.out.println(queue.poll());
	}

}
