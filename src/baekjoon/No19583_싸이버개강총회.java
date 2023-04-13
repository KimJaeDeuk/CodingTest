package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No19583_싸이버개강총회 {
	
	static int[] timeList = new int[3];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<3; i++) {
			String time = st.nextToken();
			int total = getSecTime(time);
			timeList[i] = total;
		}
		
		String str = "";
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		while((str=br.readLine())!=null) {
			String line[] = str.split(" ");
			int timeType = -1;
			int sec = getSecTime(line[0]);
			
			if(sec <= timeList[0]) {
				timeType = 0;
			}else if(sec >= timeList[1] && sec <= timeList[2]){
				timeType = 1;
			}
			if(!map.containsKey(line[1]) && timeType == 0) {
				
				map.put(line[1], 1);
			}else if(map.containsKey(line[1])&&(timeType==1)){
				
				map.put(line[1], 2);
				
			}
		}
		int cnt=0;
		for(String key : map.keySet()) {
			if(map.get(key)==2){
				cnt++;
			} 
		}
		System.out.println(cnt);
	}

	
	
	
	//문자열 분 초를 전체 초로 변환
	private static int getSecTime(String time) {
		
		String[] split_time = time.split(":");
		int total = Integer.parseInt(split_time[0])*60 + Integer.parseInt(split_time[1]);
		
		return total;
	}

}
