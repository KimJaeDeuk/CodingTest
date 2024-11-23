package samsung;

import java.util.ArrayList;

public class Pro_병사관리UserSolution {
	private static final int SOL_CNT = 1000001;
	private int[][] team;
	private int[] solTeam;
	private ArrayList<ArrayList<Integer>> list;
	public void init()
	{	
		//해당 팀의 MID번째 병사의 score
		team = new int[6][SOL_CNT];
		//해당 병사의 팀
		solTeam = new int[SOL_CNT];
		
		//업데이트를 위한 List 생성
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<6; i++) {
			list.add(new ArrayList<Integer>());
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		team[mTeam][mID] = mScore;
		solTeam[mID] = mTeam;
		list.get(mTeam).add(mID);
	}
	
	public void fire(int mID)
	{
		int team_num = solTeam[mID];
		team[team_num][mID] = 0;
		solTeam[mID] = 0;
		list.get(team_num).remove(Integer.valueOf(mID));
	}

	public void updateSoldier(int mID, int mScore)
	{
		int team_num = solTeam[mID];
		team[team_num][mID] = mScore;
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		ArrayList<Integer> teamSoldierList = list.get(mTeam);
		
		for(int i=0; i<teamSoldierList.size(); i++) {
			int sol_num = teamSoldierList.get(i);
			
			team[mTeam][sol_num] = team[mTeam][sol_num] + mChangeScore;
			if(team[mTeam][sol_num] < 1) {
				team[mTeam][sol_num] = 1;
			}else if(team[mTeam][sol_num]>5) {
				team[mTeam][sol_num] = 5;
			}
			
		}
	}
	
	public int bestSoldier(int mTeam)
	{
		ArrayList<Integer> teamList = list.get(mTeam);
		int max_mID = 0;
		int max_score = 0;
		int team_arr[] = team[mTeam];
		for(int solNum : teamList) {
			int score = team_arr[solNum];
			
			if(score > max_score) {
				score= max_score;
				max_mID = solNum;
			}else if(score >= max_score) {
				max_mID = Math.max(max_mID, solNum);
			}
		}
		
		return max_mID;
	}
}