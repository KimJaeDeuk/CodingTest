package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Day{
	int d;
	int m;
	int y;
	public Day(int y, int m, int d){
		this.d = d;
		this.m = m;
		this.y = y;
	}
}
public class No1308_Dday {
	static int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
	static int nowDay = 0;
	static int laterDay = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Day now = new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine(), " ");
		Day later = new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		if(later.y-now.y>1000) {
			System.out.println("gg");
			System.exit(0);
		}else if(later.y-now.y==1000) {
			if(later.m - now.m >0) {
				System.out.println("gg");
				System.exit(0);
			}else if(later.m - now.m == 0){
				if(later.d-now.d>=0) {
					System.out.println("gg");
					System.exit(0);
				}
			}
		}
		nowDay = getDay(now);
		laterDay = getDay(later);
		
		System.out.println("D-"+(laterDay - nowDay));
		
		
	}
	private static int getDay(Day now) {
		int nn=0;
		for(int i=1; i<now.y; i++) {
			if(i%4==0) {
				if(i%100==0) {
					if(i%400==0) {
						nn +=366;
					}else {
						nn +=365;
					}
				}else {
					nn +=366;
				}
			}else
				nn +=365;
		}
		for(int i=1; i<now.m; i++) {
			if(i==2) {
				if(now.y%4==0) {
					if(now.y%100==0) {
						if(now.y%400==0) {
							nn +=29;
						}else {
							nn +=28;
						}
					}else {
						nn +=29;
					}
				}else {
					nn +=28;
				}
			}else {
				nn += monthDay[i-1];
			}
		}
		nn += now.d;
		return nn;
	}

}
