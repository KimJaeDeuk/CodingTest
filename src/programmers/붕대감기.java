package programmers;

public class 붕대감기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));

		
	}
	public static int solution(int[] bandage, int health, int[][] attacks) {
		int t = bandage[0]; // 시전 시간
		int x = bandage[1]; // 초당 회복량
		int y = bandage[2]; // 추가 회복량
		
		int at_cnt = 0;
		int h_cnt = 0;
		int time = 0;
		int max_health = health;
		while(at_cnt < attacks.length) {
			// 공격 시간
			if(time == attacks[at_cnt][0]) {
				h_cnt = 0;
				health -= attacks[at_cnt][1];
				at_cnt++;
				if(health <= 0 ) return -1;
			} else {
				health += x;
				h_cnt++;
				if(h_cnt == t) {
					health += y;
					h_cnt = 0;
				}
				if(health > max_health) health = max_health;
			}
			
			
			time++;
		}
		return health;
	}
}
