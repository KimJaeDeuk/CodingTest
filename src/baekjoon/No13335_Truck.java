package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13335_Truck {
	
	
	static int n;
	static int w;
	static int L;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n=  Integer.parseInt(st.nextToken());
		w=  Integer.parseInt(st.nextToken());
		L=  Integer.parseInt(st.nextToken());
		int[] bridge = new int[n*2+w];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=n-1; i>=0; i--) {
			bridge[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(getTime(bridge));
		
	}

	private static int getTime(int[] bridge) {
		int time=0;
		//0 부터 n+w-1까지가 0이 되면서 n ~ n+w-1에 있는 수는 <L 보다 작게
		
		while(getBridge(bridge))
		{	
			
			
			time++;
			moveTruck(bridge);
			
		}
		return time;
	}

	private static void moveTruck(int[] bridge) {
		
		for(int i=bridge.length-2; i>=0; i--) {
			if(bridge[i+1] + bridge[i]==0) {
				continue;
			}
			int temp = bridge[i+1];
			bridge[i+1] = bridge[i];
			bridge[i] = temp;
			if(L < onBridgeTruck(bridge)) {
				bridge[i] = bridge[i+1];
				bridge[i+1] = temp;
				return;
			}
			if(bridge[bridge.length-1] != 0)
				bridge[bridge.length-1] = 0;
		}
		
	}

	private static int onBridgeTruck(int[] bridge) {
		int sum=0;
		for(int i=n; i<n+w; i++) {
			sum+= bridge[i];
		}
		return sum;
	}

	private static boolean getBridge(int[] bridge) {
		for(int i=0; i<n+w; i++) {
			if(bridge[i]!=0)
				return true;
		}
		return false;
	}

}
