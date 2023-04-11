package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sin{
	int green;
	int red;
	Sin(int r, int g){
		this.green = g;
		this.red = r;
	}
	
	public boolean getNow(int sec) {
		
		while(sec>=0) {
			sec -= red;
			if(sec <= 0) {
				return false;
			}
			sec -= green;
			if(sec<=0) {
				return true;
			}
		}
		return true;
	}
}

public class No2980_도로와신호등 {
	static int N;
	static int L;
	public static void main(String[] args) throws Exception{
		int[] arr;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		Sin[] sinList = new Sin[N+1];
		
		int s_place = 0;
		int sec = 0;
		
		arr = new int[L+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int place = Integer.parseInt(st.nextToken());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			Sin s = new Sin(red, green);
			
			arr[place] = i;
			sinList[i] = s;
		}
		
		
		
		while(s_place<L) {
			sec++;
			
			if(arr[s_place]!=0) {
				if(sinList[arr[s_place]].getNow(sec)) {
					s_place++;
				}
			}else {
				s_place++;
			}
			
		}
		System.out.println(sec);
	}

}
