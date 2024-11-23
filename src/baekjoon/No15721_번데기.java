package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No15721_번데기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int guho = Integer.parseInt(br.readLine());
		int cnt = 1;
		int who = -1;
		int guhoCnt[] = new int[2];
		while(true) {
			
			for(int i =0; i<2; i++) {
				
				guhoCnt[0]++;
				who++;
				if(guhoCnt[0]==T && guho==0) {
					System.out.println(who%A);
					return;
				}
				guhoCnt[1]++;
				who++;
				if(guhoCnt[1]==T && guho == 1) {
					System.out.println(who%A);
					return;
				}
				
			}
			for(int i=0; i<2; i++) {
				for(int j=0; j<cnt+1; j++) {
					guhoCnt[i]++;
					who++;
					if(guhoCnt[i]==T && guho == i) {
						System.out.println(who%A);
						return;
					}
				}
			}
			
			
			cnt++;
		}
	}

}
