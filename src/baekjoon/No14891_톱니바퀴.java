package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14891_톱니바퀴 {
	static int arr[][] = new int[4][8];	//2, 6 동 서
	static int top[] = new int[4];
	static int r_target, bound;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<4; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			r_target = Integer.parseInt(st.nextToken())-1;
			bound = Integer.parseInt(st.nextToken());
			
			rotateLeft(r_target, r_target-1, bound==1 ? -1 : 1);
			rotateRight(r_target, r_target+1, bound==1 ? -1 : 1);
			//자기자신 회전
			if(bound==1) {
				top[r_target] = top[r_target]-bound < 0 ? 7 : top[r_target]-bound; 
			}else {
				top[r_target] = top[r_target]-bound > 7 ? 0 : top[r_target]-bound;
			}
//			System.out.println();
//			System.out.printf("%d 번명령 : %d번째 톱니바퀴를 %d방향으로\n", i+1, r_target, bound);
//			
//			System.out.println("top 위치");
//			for(int a=0; a<4; a++) {
//				System.out.printf("%2d", top[a]);
//			}
//			System.out.println();
//			System.out.println("각 바퀴 Top의 값");
//			for(int a=0; a<4; a++) {
//				System.out.printf("%2d", arr[a][top[a]]);
//			}
		
		}
		int sum = 0;
		for(int i=0; i<4; i++) {
			if(arr[i][top[i]]==1) {
				sum += Math.pow(2,i);
			}
		}
//		System.out.println();
		System.out.println(sum);
	}
	private static void rotateRight(int target, int num, int bound) {
		if(num>=4) {
			return;
		}
		
		int targetRight = top[target]+2 >7 ? top[target]-6 : top[target]+2;
		int rightLeft = top[num]+6 >7 ? top[num]-2 : top[num]+6;
//		System.out.printf("target바퀴 : %d , 오른쪽바퀴 : %d, 방향 : %d, targetRight : %d, 오른쪽바퀴 왼쪽 : %d\n", target, num, bound, targetRight, rightLeft);
//		System.out.printf("target의 오른쪽 극 : %d, 오른쪽의 왼쪽번호 : %d\n", arr[target][targetRight], arr[num][rightLeft]);
		
		if(arr[target][targetRight] != arr[num][rightLeft]) {
			
			rotateRight(num, num+1, bound==1 ? -1 : 1);
			
			if(bound==1) {
				top[num] = top[num]-bound < 0 ? 7 : top[num]-bound; 
			}else {
				top[num] = top[num]-bound > 7 ? 0 : top[num]-bound;
			}
		}
		
		 
		
	}
	private static void rotateLeft(int target, int num, int bound) {
		
		if(num<0) {
			return;
		}
		
		int targetLeft = top[target]+6 >7 ? top[target]-2 : top[target]+6;
		int leftRight = top[num]+2 >7 ? top[num]-6 : top[num]+2;
//		System.out.printf("target바퀴 : %d , 왼쪽바퀴 : %d, 방향 : %d, targetLeft : %d, 왼쪽바퀴 오른쪽 : %d\n", target, num, bound, targetLeft, leftRight);
//		System.out.printf("target의 왼쪽 극 : %d, 왼쪽의 오른쪽번호 : %d\n", arr[target][targetLeft], arr[num][leftRight]);
		if(arr[target][targetLeft] != arr[num][leftRight]) {
			
			rotateLeft(num, num-1, bound==1 ? -1 : 1);
			
			if(bound==1) {
				top[num] = top[num]-bound < 0 ? 7 : top[num]-bound; 
			}else {
				top[num] = top[num]-bound > 7 ? 0 : top[num]-bound;
			}
		}
	}

}
