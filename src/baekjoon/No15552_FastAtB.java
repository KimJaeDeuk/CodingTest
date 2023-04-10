package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15552_FastAtB {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());	//enter를 기준으로 한 줄을 읽음
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");	//띄어쓰기를 기준으로 읽음
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			sb.append(sum(A,B)).append("\n");	//함수 return값을 sb에 담아주고 개행을 추가
		}
		System.out.println(sb);	//모든 결과값을 담아준 sb 출력

	}

	private static int sum(int a, int b) { 
		return a+b;
	}

}
