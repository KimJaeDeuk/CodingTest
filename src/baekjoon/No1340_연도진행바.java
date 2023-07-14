package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1340_연도진행바 {
	static int dayList[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	static String[] monthList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ,:");
		
		String month = st.nextToken();
		int day = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		//System.out.println(month + " " + day + " " + year + " " + hour + " " + min);
		
		
		boolean yearCheck = true;	// T : 평년 / F : 윤년
		
		if(year%400==0 || (year%4==0 && year%100!=0)) {
			yearCheck = false;
			dayList[1] = 29;
		}
		int yearTotal = yearCheck ? 365*24*60 : 366*24*60;
		int totalDay = day-1;
		for(int i=0; i<12; i++) {
			if(monthList[i].equals(month)) {
				for(int j=0; j<i; j++) {
					totalDay += dayList[j];
				}
				break;
			}
		}
	
		//System.out.println(totalDay);
		totalDay = totalDay*24*60 + hour*60 + min;
		//System.out.println(totalDay + " " + yearTotal);
		double percent = (double)(totalDay*100)/yearTotal;
		System.out.println(percent);
		

	}

}
