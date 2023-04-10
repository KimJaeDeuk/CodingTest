package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1244_SwitchOnOff {
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] onOff = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			onOff[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int sex = Integer.parseInt(st.nextToken());
			
			if(sex==1) {
				int num = Integer.parseInt(st.nextToken());
				
				for(int j=num; j<=N; j+=num) {
					onOff[j] = onOff[j]==1 ? 0 : 1;
				}
			}
			
			else {
				int num = Integer.parseInt(st.nextToken());
				
				onOff[num] = onOff[num]==1 ? 0 : 1;
				for(int j=1; j<=N/2; j++) {
					if(num-j < 1 || num+j > N) {
						break;
					}
					if(onOff[num-j] == onOff[num+j]) {
						onOff[num-j] = onOff[num-j]==1 ? 0 : 1;
						onOff[num+j] = onOff[num+j]==1 ? 0 : 1;
					}
					else {
						break;
					}
				}
			}
			
		}
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<=N; i++) {
			if(i%10==0)
				sb.append(onOff[i]).append("\n");
			else
				sb.append(onOff[i]).append(" ");
			
		}
		System.out.println(sb);
	}

}
