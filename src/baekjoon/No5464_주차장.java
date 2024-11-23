package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5464_주차장 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int car[] = new int[M+1];
		
		int cost[] = new int[N];
		
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		for(int i=1; i<M+1; i++) {
			car[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		
		int[] park = new int[N];
		Queue<Integer> wait = new LinkedList<>();
		for(int i=0; i<M*2; i++) {
			int into = Integer.parseInt(br.readLine());
			int carNo = Math.abs(into);
			if(into < 0) {
				for(int j=0; j<park.length; j++) { // 주차한 위치를 찾기
					if(park[j] == carNo) {
						sum += cost[j] * car[carNo]; //주차한 위치와 차 번호로 금액을 산정
						if(!wait.isEmpty()) {	// 입장 대기중인 차량이 있다면 넣어줌
							park[j] = wait.poll();
						}else {
							park[j] = 0;		// 입장 대기중이 아니라면 빈공간으로 처리
						}
						break;
					}
				}
				
			} else {
				if(wait.size()>=M) {
					wait.add(carNo);
				} else {
					boolean p = false;
					for(int j=0; j < park.length; j++) {
						if(park[j]==0) {
							park[j] = carNo;
							p = true;
							break;
						}
					}
					if(!p)
					wait.add(carNo);
				}
			}
		}
		
		System.out.println(sum);
	}

}


/*
 * 1 : 200
 * 2 : 100
 * 3: 300
 * 4: 800
 * 
 *  p1 + 3
 *  p2 + 2
 *  p1 - 3  600
 *  p1 + 1
 *  p3 + 4
 *  p3 - 4  4000
 *  p2 - 2  200
 *  p1 - 1  
 * */
 