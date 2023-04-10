package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No1966_PrinterQueue { //TODO : PrinterQueue 풀어야함

	static int T;
	static int N;

	public static void main(String[] args) throws  IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		T = Integer.parseInt(br.readLine());

		while(T-->0) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			int place = Integer.parseInt(st.nextToken());
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st1.nextToken()));
			}

			sb.append(getSeq(list, place)).append("\n");
		}
		System.out.println(sb);
	}
	private static int getSeq(ArrayList<Integer> list, int place) {
		int seq=1;					//몇번째에 빠지는지
		while(!list.isEmpty()) {	//list가 빌때까지
			boolean check = true;	//check 일단 넣어봄
			int max =0;				//max와 idx로 최대값선정 및 최대값 index 추출
			int idx=0;
			for(int i=0; i< list.size(); i++) {
				if(list.get(i) > max) {
					max = list.get(i);
					idx = i;
				}

			}
			if( idx == place ) {	//만약 최대값 index와 얻고자하는 위치값ㅇㅣ같다면
				return seq;			//seq return
			}
			else {
				
				list.remove(idx);	//최대값을 갖고있는 index 삭제
				place--;
				int getPlace;
				if(place > idx) {
					place = list.size()-1 -idx;
				}
				else {
					place = idx+place-list.size();
				}
				for(int i=0; i<idx; i++) {	//최대값의 index보다 작다면
					list.add(list.get(0));	//list 뒤에 첫번째값 추가
					list.remove(0);			//list의 첫번째값 제거
					
				}
				
			}
			seq++; //순서한번 돌았음 seq++
		}

		return seq;
	}

}
