package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2503_BaseballGame {

	static String num;
	static int strike;
	static int ball;
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> list_after = new ArrayList<String>();
	static boolean first = true;
	static boolean three = false;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for(int i=123; i<=987; i++) {
			if(checkSame(i))
				continue;
			else
				list.add(String.valueOf(i));
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			num = st.nextToken();
			strike = Integer.parseInt(st.nextToken());
			ball = Integer.parseInt(st.nextToken());

			getTarget();
			list.removeAll(list_after);
			list_after = new ArrayList<String>();
		}
		System.out.println(list.size());

	}
	private static void getTarget() {

		for(String listOfNum : list) {
			
			int stCnt=0;
			int bCnt=0;
			for(int s=0; s<3; s++) {
				if(listOfNum.charAt(s) == num.charAt(s)) {
					stCnt++;
				}
					
			}
			
			for(int b=0; b<3; b++) {
				for(int t=0; t<3; t++) {
					if(listOfNum.charAt(b) == num.charAt(t)) {
						if(b!=t) {
							bCnt++;
						}
					}
				}
			}
			
			if(bCnt!=ball || stCnt != strike) {
				list_after.add(listOfNum);
			}
			
		}
	}
	private static boolean checkSame(int i) {
		String s = String.valueOf(i);
		boolean flag = false;
		if(s.charAt(0) == s.charAt(1))
			flag = true;
		else if(s.charAt(1) == s.charAt(2))
			flag = true;
		else if(s.charAt(0)==s.charAt(2))
			flag = true;
		
		if(s.charAt(1)=='0' || s.charAt(2)=='0')
			flag = true;
		
		return flag;
	}

}
