package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ResevationRoom {

	static int roomCnt;
	
	static int reserveCnt;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		roomCnt = Integer.parseInt(st.nextToken());
		reserveCnt = Integer.parseInt(st.nextToken());
		
		String rName[] = new String[roomCnt];
		for(int i=0; i<roomCnt; i++) {
			rName[i] = br.readLine();
		}
		Arrays.sort(rName);
		
		int[][] reserve = new int[roomCnt][19];
		for(int i=0; i<reserveCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String room = st.nextToken();
			for(int j=0; j<roomCnt; j++) {
				if(room.equals(rName[j])) {
					int start = Integer.parseInt(st.nextToken());
					int end = Integer.parseInt(st.nextToken());
					
					for(int k=start; k<=end; k++) {
						reserve[j][k] = 1;
					}
				}
			}
		}
		
		
		
		for(int i=0; i<roomCnt; i++) {
			sb.append("Room "+rName[i]+":").append("\n");
			boolean available = true;
			int cnt = 0;
			String[] ableTime = new String[15];
			String time ="";
			for(int j=9; j<=18; j++) {
				if(available && reserve[i][j]==0) {
					cnt++;
					available = false;
					if(j==9) {
						time = "0"+String.valueOf(j) + "-";
					}else {
						time = String.valueOf(j-1)+"-";
					}
				}
				else if(!available && reserve[i][j] != 0) {
					available = true;
					time += String.valueOf(j);
					ableTime[cnt] = time;
					time ="";
				}
				else if(!available && j==18 && reserve[i][j] ==0) {
					time += String.valueOf(j);
					ableTime[cnt] = time;
					time ="";
				}
			}
			if(cnt == 0) {
				sb.append("Not available").append("\n");
			}
			else {
				sb.append(cnt+" available:").append("\n");
				for(int a=0; a<=14; a++) {
					if(ableTime[a] != null) {
						sb.append(ableTime[a]).append("\n");
					}
				}
			}
			
			if(i+1 != roomCnt)
				sb.append("-----").append("\n");
		}
		System.out.println(sb);

	}

}
