package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1713_HuboChucheon {


	public static void main(String[] args) throws Exception{
		int N;
		int ChuCnt;
		 ArrayList<Integer> list;
		 int[] result;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		ChuCnt = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		result = new int[101];
		list = new ArrayList<Integer>();
		for(int i=0; i<ChuCnt; i++) {
			int who = Integer.parseInt(st.nextToken());	//입력

			result[who] += 1;							//추천 +1회

			if(!list.contains(who)) {					//만약 없으면 추가
							
				if(list.size()==N) {					//리스트 사이즈가 3보다 크면
					
					int minCnt=Integer.MAX_VALUE;	//최소카운트
					
					
					//최소추천횟수 구하기
					for(int num : list) {			//후보학생들 번호
						
						if(minCnt > result[num]) {	//만약 후보학생번호의 갯수가 minCnt보다 작다면
							
							minCnt = result[num];	//최소갯수 minCnt에 대입
								
						}
					}
					
					for(int num : list) {
						if(result[num]==minCnt) {
							list.remove(list.indexOf(num));
							list.add(who);
							result[num] = 0;
							break;
						}
					}

				}else {
					list.add(who);
				}
			}
		}
		Collections.sort(list);
		for(int i : list)
			sb.append(i).append(" ");
		System.out.println(sb);
	}
}
