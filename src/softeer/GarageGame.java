package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GarageGame {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	

	}

}
/*
 * 가로 세로 N (격자있음) 
 * 각 차고에 색깔이 있는 자동차 1개씩
 * 한턴에 한칸 선택해 선택한 칸과 상하좌우칸에 들어있는 자동차의 색이 같다면 모두 사라짐
 * 연결된칸들의 상하좌우 칸에 들어있는 자동차의 색이 같다면 함께 사라짐
 * bfs , Queue
 * 
 * 획득가능점수 
 * 사라진 자동차의 개수와 사라지는 차고 칸을 모두 포함하는 가장 작은 직사각형의 넓이 합 
 * minX minY maxX maxY
 * 
 * 
 * */
