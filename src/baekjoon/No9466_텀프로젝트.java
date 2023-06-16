package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No9466_텀프로젝트 {
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(TC-->0) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<Integer>();
			int student[] = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<N+1; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = makeTeam(N, student);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static int makeTeam(int n, int[] student) {
		int cnt=0;
		
		
		
		for(int i=1; i<n+1; i++) {
			if(list.indexOf(i)==-1)
			if(check(n,i, student)) {
				cnt++;
			}
		}
		
		
		
		return cnt;
	}

	private static boolean check(int n, int i, int[] student) {
		int cnt=0;
		
		int target = student[i];
		
		while(i!=target) {
			cnt++;
			if(list.indexOf(target)!= -1) return false;
			target = student[target];
			
			if(cnt==n && i!=target) { return true;}
		}
		target = student[i];
		list.add(i);
		while(i!=target) {
			list.add(target);
			target = student[target];
		}
		
		return false;
	}

}
