package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No9017_크로스컨트리 {
	static class ScoreSeq{
		int score;
		int seq;
		ScoreSeq(int sc, int se){
			this.score = sc;
			this.seq = se;
		}
	}
	public static void main(String[] args) throws Exception{
		
		 // 등수, 점수, 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb  =new StringBuilder();
		while(T--> 0 ) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<Integer, ArrayList<ScoreSeq>> scoreMap = new HashMap<Integer, ArrayList<ScoreSeq>>();
			int isTeam[] = new int[201];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				isTeam[arr[i]]++;
			}
			int score = 0;
			for(int i=0; i<N; i++) {
				if(isTeam[arr[i]]>=6) {
					if(!scoreMap.containsKey(arr[i])) {
						ArrayList<ScoreSeq> list = new ArrayList<>();
						list.add(new ScoreSeq(++score, i));
						scoreMap.put(arr[i], list);
					}else {
						scoreMap.get(arr[i]).add(new ScoreSeq(++score, i));
					}
				}
			}
			int minFive = Integer.MAX_VALUE;
			int minSum = Integer.MAX_VALUE;
			int minTeam = 0;
			for(int team : scoreMap.keySet()) {
				
				ArrayList<ScoreSeq> list = scoreMap.get(team);
				
				Collections.sort(list, new Comparator<ScoreSeq>() {
					public int compare(ScoreSeq o1, ScoreSeq o2) {
						return Integer.compare(o1.score, o2.score);
					}
				});
				for(ScoreSeq seq : list) {
					System.out.println(seq.score + " " + seq.seq);
				}
				int sum = list.get(0).score + list.get(1).score + list.get(2).score + list.get(3).score;
				int seq = list.get(4).seq;
				if(minSum > sum) {
					minSum = sum;
					minTeam = team;
					minFive = seq;
				}else if(minSum == sum) {
					if(minFive > seq) {
						minFive = seq;
						minTeam = team;
					}
				}
				
			}
			
			sb.append(minTeam).append("\n");
		}
		
		System.out.println(sb);
		

	}


}
