package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2564_Security {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//N == 세로 M==가로

		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		//0번째 y축 1번쨰 x축
		
		int store = Integer.parseInt(br.readLine());
		int place[][] = new int[store+1][2];
		
		for(int i=1; i<=store; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1) {
				place[i][0] = 0;
				place[i][1] = b;
			} else if(a==2){
				place[i][0] = N;
				place[i][1] = b;
			} else if(a==3) {
				place[i][0] = b;
				place[i][1] = 0;
			} else if(a==4) {
				place[i][0] = b;
				place[i][1] = M;
			}
		}
		
		
		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] dong = new int[2];
		if(a==1) {
			dong[0] = 0;
			dong[1] = b;
		} else if(a==2){
			dong[0] = N;
			dong[1] = b;
		} else if(a==3) {
			dong[0] = b;
			dong[1] = 0;
		} else if(a==4) {
			dong[0] = b;
			dong[1] = M;
		}

		int sum=0;
		for(int i=1; i<=store; i++) {
			if((dong[0]==0 && place[i][0] ==N )|| (dong[0]==N && place[i][0]==0)) {
				int min = (dong[1] +place[i][1] ) < (M-dong[1] + M-place[i][1]) ? dong[1] +place[i][1] : M-dong[1] + M-place[i][1];
				sum+= min + N;
				
			}else if( (dong[1]==0 && place[i][1]==M) || (dong[1]==M && place[i][1]==0)){
				
				int min = (dong[0] +place[i][0] ) < (M-dong[0] + M-place[i][0]) ? dong[0] +place[i][0] : M-dong[0] + M-place[i][0];
				sum+= min + M;
				
			}else {
				sum += Math.abs(place[i][0] - dong[0]) + Math.abs(place[i][1] - dong[1]);
			}
		}
		
		System.out.println(sum);
		
		
		
		
		
		
	}

}
