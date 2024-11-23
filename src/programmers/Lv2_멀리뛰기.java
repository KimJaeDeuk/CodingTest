package programmers;

public class Lv2_멀리뛰기 {
	private static long cnt = 0;
	public static void main(String[] args) {
		int n = 4;
		long answer = solution(n);
		System.out.println(answer);
	}

	private static long solution(int n) {
		long answer = 0;
		
		dfs(n, 1, 0);
		
		answer = cnt;
		return answer;
	}

	private static void dfs(int n, int k, int sum) {
		
		if(n == sum) {
			cnt++;
			return;
		} else if(sum > n) {
			return;
		} else {
			
			for(int i=1; i<=2; i++) {
				
				dfs(n, 0, sum+i);
			}
		}
	}

}
