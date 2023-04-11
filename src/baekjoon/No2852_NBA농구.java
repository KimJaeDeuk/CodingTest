package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2852_NBA농구 {
	static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] score = new int[3];
		
		N = Integer.parseInt(br.readLine());
		
		int saveSec = 0;
		
		int one = 0;
		int two = 0;
		int win = -1;
		int beforeNum = 0;
		int beforeSaveSec = 0;
		for(int i=0; i<N; i++) {
			if(one > two) {
				win = 1;
			}else if(one < two) {
				win = 2;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			if(num==1) {
				one++;
			}else
				two++;
			
			String time = st.nextToken();
			String[] s_time = time.split(":");
			
			int min = Integer.parseInt(s_time[0]);
			int sec = Integer.parseInt(s_time[1]); 
			
			saveSec = (min*60) + sec;
			
			if(win!=-1) 
				score[win] += saveSec - beforeSaveSec;
			
			
			beforeNum = num;
			beforeSaveSec = saveSec;
			win = -1;
		}
		int lastTime = 48*60;
		
		if(one > two) {
			win = 1;
		}else if(one < two) {
			win = 2;
		}
		
		if(win!=-1) 
			score[win] += (lastTime - saveSec);
		
		
		for(int i=1; i<3; i++) {
			
			int time = score[i];
			int min = time / 60;
			int sec = time % 60;
			String s_min = min < 10 ? "0"+String.valueOf(min) : String.valueOf(min);
			String s_sec = sec < 10 ? "0"+String.valueOf(sec) : String.valueOf(sec);
			System.out.println(s_min+":"+s_sec);
			
		}
		
	}

}
