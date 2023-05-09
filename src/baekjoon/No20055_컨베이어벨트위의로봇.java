package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Belt{
	int dur;
	boolean robot;
	Belt(int dur){
		this.dur = dur;
	}
	
	public void setRobot(boolean r) {
		this.robot = r;
	}
	public boolean isRobot() {
		return this.robot;
	}
}

public class No20055_컨베이어벨트위의로봇 {

	
	public static void main(String[] args) throws Exception{
		int cnt=0;
		int N, K;
		int kCnt = 0;
		ArrayList<Belt> list = new ArrayList<Belt>(); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N*2; i++) {
			list.add(new Belt(Integer.parseInt(st.nextToken())));
		}
		
		while(kCnt<K) {
			//과정 1 벨트가 각 칸위에 있는 로봇과 함께 한칸 회전
			cnt++;
			kCnt=0;
			list.add(0,list.remove(list.size()-1));
			if(list.get(N-1).isRobot()) {
				list.get(N-1).setRobot(false);
			}
			//과정 2 벨트에 올라간 로봇 회전방향으로 한칸 이동
					//이동하려는칸에 로봇이 없어야 하며 그 칸의 내구도가 1 이상 있어야함.
			for(int i=N-2; i>=0; i--) {
				if(list.get(i).isRobot() && !list.get(i+1).isRobot() && list.get(i+1).dur!=0) {
					list.get(i).setRobot(false);
					list.get(i+1).setRobot(true);
					list.get(i+1).dur = list.get(i+1).dur-1;
					if(i==N-2) list.get(i+1).setRobot(false); 
				}
			}
			
			//과정 3
			if(list.get(0).dur!=0) {
				list.get(0).setRobot(true);
				list.get(0).dur--;
			}
			
			//과정 4
			for(Belt b : list) {
				if(b.dur==0)
					kCnt++;
			}
			
			
		}
		System.out.println(cnt);
		
		
	}

}
