package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Work{
	int aWork;
	int bWork;
	int aMove = 1000000;
	int bMove = 1000000;
	public Work(int aw, int bw, int am, int bm){
		this.aWork = aw;
		this.bWork = bw;
		this.aMove = am;
		this.bMove = bm;
	}
	public Work(int aw,int bw) {
		this.aWork = aw;
		this.bWork = bw;
	}
}
public class 조립라인 {
	static int N;
	static int time = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		ArrayList<Work> list = new ArrayList<Work>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int aW = Integer.parseInt(st.nextToken());
			int bW = Integer.parseInt(st.nextToken());
			int aM = Integer.parseInt(st.nextToken());
			int bM = Integer.parseInt(st.nextToken());
			list.add(new Work(aW,bW,aM,bM));
		}
		st = new StringTokenizer(br.readLine(), " ");
		list.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		
		int dp[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			dp[i][0] = 1000000;
			dp[i][1] = 1000000;
		}
		dp[0][0] = list.get(0).aWork;
		for(int i=1; i<N; i++) {
			Work nowW = list.get(i);
			Work beforeW = list.get(i-1);
//			System.out.println("now AWork time " + nowW.aWork + " nowAMoveTime" + nowW.aMove);
//			System.out.println("now BWork time " + nowW.bWork + " nowBMoveTime" + nowW.bMove);
//			System.out.println("before AWork time " + beforeW.aWork + " before AMoveTime" + beforeW.aMove);
//			System.out.println("before BWork time " + beforeW.bWork + " before BMoveTime" + beforeW.bMove);
			dp[i][0] = Math.min(dp[i-1][0] + nowW.aWork, dp[i-1][1]+beforeW.bMove + nowW.aWork);
//			System.out.println("[A 그대로 : " +( dp[i-1][0] + nowW.aWork)+ "] [옮겼을떄 : " + dp[i-1][1]+beforeW.bMove + nowW.aWork + "]");
//			System.out.println("[B 그대로 : " + dp[i-1][1] + nowW.bWork+ "] [옮겼을떄 : " + (dp[i-1][0]+beforeW.aMove + nowW.bWork) + "]");
//			if(dp[i-1][0] > dp[i-1][1]+beforeW.bMove) {
//				dp[i][0] = dp[i-1][1] +  beforeW.bMove + nowW.aWork; 
//			}else {
//				dp[i][0] = dp[i-1][0] + nowW.aWork;
//			}
			dp[i][1] = Math.min( (dp[i-1][0] +  beforeW.aMove + nowW.bWork), (dp[i-1][1] + nowW.bWork));
//			if(dp[i-1][1] > dp[i-1][0]+beforeW.aMove) {
//				dp[i][1] = dp[i-1][0] +  beforeW.aMove + nowW.bWork; 
//			}else {
//				dp[i][1] = dp[i-1][1] + nowW.bWork;
//			}
			
//			if(nowW.aWork > beforeW.aMove + nowW.bWork) {
//				dp[i][0] = beforeW.aMove + nowW.bWork;
//			}else {
//				dp[i][0] = nowW.aWork;
//			}
//			
//			if(nowW.bWork > beforeW.bMove + nowW.aWork) {
//				
//			}
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(dp[i][0] + " " + dp[i][1]);
//		}

		//dfs(true, 0, list.get(0).aWork);
		
//		for(int i=0; i<N-1; i++) {
//			if(i==0)
//				time = list.get(i).aWork;
//			
//			Work nowW = list.get(i);
//			Work nextW = list.get(i+1);
//			if(workPlace) {
//				if(nowW.bMove+nextW.bWork <= )
//				int nextTime = nowW.bMove+nextW.bWork;
//				
//			}else {
//				
//			}
//	
		
		System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
	}

	
	private static void dfs(boolean workPlace, int now, int dTime) {
		
//		if(now==N-1) {
////			System.out.println("현재 도는곳이 " + now + " 일때");
////			System.out.println(time + " " + dTime + "\n-------------");
//			time = Math.min(time, dTime);
//			return;
//		}
//		
//		for(int i=now; i<N-1; i++) {
//			Work nowW = list.get(i);
//			Work nextW = list.get(i+1);
//			
//			if(workPlace) {
//				if(nowW.aMove + nextW.bWork < nextW.aWork) {
//					dfs(false, now+1, dTime + nowW.aMove+nextW.bWork);
//				}else if(nowW.aMove + nextW.bWork > nextW.aWork) {
//					dfs(true, now+1, dTime + nextW.aWork);
//				}else if(nowW.aMove + nextW.bWork == nextW.aWork) {
//					dfs(true, now+1, dTime + nextW.aWork);
//					dfs(false, now+1, dTime + nextW.aWork);
//				}
//			}else {
//				if(nowW.bMove + nextW.aWork < nextW.bWork) {
//					dfs(true, now+1, dTime + nowW.bMove+nextW.aWork);
//				}else if(nowW.bMove + nextW.aWork > nextW.bWork) {
//					dfs(false, now+1, dTime + nextW.bWork);
//				}else if(nowW.bMove + nextW.aWork == nextW.bWork) {
//					dfs(true, now+1, dTime + nextW.aWork);
//					dfs(false, now+1, dTime + nextW.aWork);
//				}
//			}
//			
//		}
	}

}
