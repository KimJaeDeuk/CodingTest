package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
class Rank{
	int num;
	int pos;
	int rank;
	Rank(int n, int r) {
		this.num = n;
		this.pos = r;
	}
	public String toString() {
		return "[num:"+num+",pos:"+pos+",rank:"+rank+"]\n";
	}
}
public class No2890_카약 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		ArrayList<Rank> list = new ArrayList<>();
		
		int min = 9999;;
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=C-2; j>=1; j--) {
				char c = line.charAt(j);
				if(c-'0' < 10 && c-'0' > 0) {
					list.add(new Rank(c-'0', C-j-1));
					break;
				}
			}
		}
		Collections.sort(list, new Comparator<Rank>() {

			@Override
			public int compare(Rank o1, Rank o2) {
				return Integer.compare(o1.pos, o2.pos);
			}
			
		});
		list.get(0).rank = 1;
		for(int i = 1; i< list.size(); i++) {
			Rank r = list.get(i);
			Rank before = list.get(i-1);
			
			if(r.pos == before.pos) {
				r.rank = before.rank;
			}else {
				r.rank = before.rank +1;
			}
		}
		Collections.sort(list, new Comparator<Rank>() {

			@Override
			public int compare(Rank o1, Rank o2) {
				return Integer.compare(o1.num, o2.num);
			}
			
		});
		for(Rank r : list) {
			System.out.println(r.rank);
		}
	}

}
