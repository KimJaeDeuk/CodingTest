package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class No3758_KCPC {
	static class Team{
		int score;
		int lastSubmit;
		int submitCnt;
		HashMap<Integer, Integer> scoreMap;
		public Team(int last, int sub) {
			this.lastSubmit = last;
			this.submitCnt = sub;
			scoreMap = new HashMap<>();
		}
		
		public void putScore(int t, int s) {
			if(!scoreMap.containsKey(t)) {
				scoreMap.put(t, s);
			} else {
				scoreMap.put(t, Math.max(scoreMap.get(t), s));
			}
		}
		
		public void totalScore() {
			int sum = 0;
			for(int sc : scoreMap.keySet()) {
				sum += scoreMap.get(sc);
			}
			this.score = sum;
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int my_team = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			HashMap<Integer, Team> rank = new HashMap<>();
				
			
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int team_id = Integer.parseInt(st.nextToken());
				int test_num = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());
				if(!rank.containsKey(team_id)) {
					Team team = new Team(i+1, 1);
					team.putScore(test_num, score);
					rank.put(team_id, team);
					
				}
				else {
					rank.get(team_id).lastSubmit = i+1;
					rank.get(team_id).submitCnt++;
					rank.get(team_id).putScore(test_num, score);
				}
			}
			for(Integer i : rank.keySet()) {
				rank.get(i).totalScore();
			}
			List<Integer> team_num = new ArrayList<>(rank.keySet());
			Collections.sort(team_num, new Comparator<Integer>() {
				
				public int compare(Integer o1, Integer o2) {
					Team t1 = rank.get(o1);
					Team t2 = rank.get(o2);
					if(Integer.compare(t2.score, t1.score) == 0) {
						
						if(Integer.compare(t1.submitCnt, t2.submitCnt) == 0) {
							return Integer.compare(t1.lastSubmit, t2.lastSubmit);
						}
						return Integer.compare(t1.submitCnt, t2.submitCnt);
					}
					return Integer.compare(t2.score, t1.score);
				}

			});
			
			
			for(int i=0; i<team_num.size(); i++) {
				if(team_num.get(i) == my_team) {
					sb.append(i+1).append("\n");
					break;
				}
			}
			
		}
		System.out.println(sb);
	}

}
