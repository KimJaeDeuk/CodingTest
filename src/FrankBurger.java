import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FrankBurger {
	
	static int DICE_MAX_NUMBER;
	static String[] name;
	static int nameLen;
	static int privateHaveNumberCnt;
	static ArrayList<Integer> jusa = new ArrayList<>();
	static int[][] number;
	
	public static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[참여할 인원의 이름을 스페이스바 기준으로 입력후 엔터를 눌러주세요]");
		System.out.println("EX) 재득 정규 고호");
	
		name = br.readLine().split(" ");
		
		nameLen = name.length;

		DICE_MAX_NUMBER = lcm();
				
		privateHaveNumberCnt = DICE_MAX_NUMBER/name.length;
		number = new int[nameLen][privateHaveNumberCnt];
		
		jusa = new ArrayList<>();
		for(int i=0; i<DICE_MAX_NUMBER; i++) {
			jusa.add(i);
		}
		
	}
	private static int lcm() {
		return nameLen*6/gcd();
	}
	private static int gcd() {
		int a = nameLen;
		int b = 6;
		while(b!=0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	private static void showParcitipateName() {
		System.out.println("참가자");
		for(String a : name) {
			System.out.print(a +" ");
		}
		System.out.println();
		
	}


	private static void setPrivateNumber() {
		int n = 0;
		int pNum = 0;
		int privateNum = 0;
		
		while(n < DICE_MAX_NUMBER) {
			int num = (int)(Math.random()*jusa.size());
			
			number[pNum][privateNum] = jusa.remove(num)+1;
			pNum++;
			if(pNum==nameLen) {
				pNum = 0;
				privateNum++;
			}
				
			n++;
			
		}
		
	}

	private static void showPrivateNumber() {
		for(int i=0; i<nameLen; i++) {
			System.out.print("["+name[i]+"의 개인번호 : ");
			for(int j=0; j<privateHaveNumberCnt; j++) {
				if(j==privateHaveNumberCnt-1)
					System.out.print(number[i][j]);
				else {
					System.out.print(number[i][j]+", ");
				}
			}
			System.out.println("]");
		}
		System.out.println("\n");
	}

	private static void chooseRandomNumber() {
		int randomNum = (int) (Math.random()*DICE_MAX_NUMBER) + 1;
		
		System.out.println("당첨번호 : " + randomNum);
		for(int i=0; i<nameLen; i++) {
			for(int j=0; j<privateHaveNumberCnt; j++) {
				if(randomNum == number[i][j]) {
					System.out.println("주문 + 배달 걸린사람 : " + name[i]);
					System.exit(0);
				}
			}
		}
	}
	

	private static void chooseMinimumSummary() {
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> min_arr = new ArrayList<>();;
		for(int i=0; i<nameLen; i++) {
			
			int sum = 0;
			sb.append(name[i]).append("의 주사위 합 : ");
			
			for(int j=0; j<privateHaveNumberCnt; j++) {
				sum += number[i][j];
			}
			min_arr.add(sum);
			sb.append(sum).append("\n");
		}
		
		int min = Collections.min(min_arr);
		sb.append("최소합 : ").append(min).append("\n");
		sb.append("당첨자 : ");
		
		for(int i=0; i<min_arr.size(); i++) {
			if(min_arr.get(i) == min) {
				sb.append(name[i]).append(", ");
				
			}
		}
		sb.delete(sb.length()-2,sb.length());
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws Exception{
		//이름 입력후 초기값 세팅
		init();
		//참여자 이름 출력
		showParcitipateName();
		//각 개인 번호 할당
		setPrivateNumber();
		//각 개인번호 출력
		showPrivateNumber();
		
		// 주사위 숫자 가진 당첨자 선정
//		chooseRandomNumber();
		
		// 주사위 합 낮은사람
		chooseMinimumSummary();
	}

}
