package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20546_기적의매매법 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mount[] = new int[2];
		int m = Integer.parseInt(br.readLine());
		mount[0] = m;
		mount[1] = m;
		
		int price[] = new int[14];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<14; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		int jun = 0, sung = 0;
		int down = 0 , up = 0;
		
		for(int i=0; i<14; i++) {
			
			if(mount[0]/price[i]!=0) {
				int cnt = mount[0]/price[i];
				jun += cnt;
				mount[0] -= price[i]*cnt;
			}	
		}
		
		for(int i=1; i<14; i++) {
			if(price[i-1] < price[i]) {
				up++;
				down = 0;
			}else if(price[i-1] > price[i]) {
				down++;
				up = 0;
			}
			
			if(up==3) {
				if(sung>0) {
					mount[1] += price[i]*sung;
					sung = 0;
				}
			}else if(down>=3) {
				if(mount[1]/price[i]!=0) {
					int cnt = mount[1]/price[i];
					sung += cnt;
					mount[1] -= price[i]*cnt;
				}
			}
		}
		
		
		
		
		int junMount = mount[0] + price[13]*jun;
		int sungMount = mount[1] + price[13]*sung;
		
		StringBuilder sb = new StringBuilder();
		if(junMount==sungMount) {
			sb.append("SAMESAME");
		}else if(junMount<sungMount) {
			sb.append("TIMING");
		}else {
			sb.append("BNP");
		}
		System.out.println(sb);
	}

}
