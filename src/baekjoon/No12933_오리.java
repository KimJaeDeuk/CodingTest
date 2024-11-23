package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No12933_오리 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		char sound[] = line.toCharArray();
		
		char[] duck = {'q','u','a','c','k'};
		int idx = 0;
		int duckCnt = 0;
		int d[] = new int[sound.length/5];
		for(int i=0; i<sound.length; i++) {
			char c = sound[i];
			for(int j=0; j<d.length; j++) {
				int before = d[j];
				if(d[j]%5==0 && c=='q') {
					d[j]++;
				} else if(d[j]%5==1 && c=='u') {
					d[j]++;
				} else if(d[j]%5==2 && c=='a') {
					d[j]++;
				} else if(d[j]%5==3 && c=='c') {
					d[j]++;
				} else if(d[j]%5==4 && c=='k') {
					d[j]++;
				} 
				
				if(before != d[j]) break;
				
			}
		}
		for(int i=0; i<sound.length/5; i++) {
			if(d[i] != 0 && d[i]%5==0) {
				duckCnt++;
			}else if (d[i]!=0 && d[i]%5!=0){
				duckCnt =-1;
				break;
			}
		}
		duckCnt = duckCnt == 0 ? -1 : duckCnt;
		System.out.println(duckCnt);
	}
}
