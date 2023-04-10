package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1969_DNA {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] dna= new String[N];
		for(int i=0; i<N; i++) {
			dna[i] = br.readLine();
		}
		String dna_s = "";
		int haming=0;
		HashMap<Character, Integer> cnt;
		for(int i=0; i<M; i++) {
			cnt = new HashMap<Character,Integer>();
			for(int j=0; j<N; j++) {
				if(!cnt.containsKey( dna[j].charAt(i))){
					cnt.put(dna[j].charAt(i),1);
				}else {
					cnt.put(dna[j].charAt(i), cnt.get(dna[j].charAt(i))+1);
				}
			}
			int maxCnt=0;
			char dna_c='0';
			for(char s : cnt.keySet()) {
				if(maxCnt < cnt.get(s)) {
					maxCnt = cnt.get(s);
					dna_c = s;
				}
				else if(maxCnt == cnt.get(s)) {
					if(s < dna_c) {
						dna_c = s;
					}
				}
			}
			haming += N-maxCnt;
			dna_s += dna_c;
			
		}
		sb.append(dna_s).append("\n");
		sb.append(haming);
		System.out.println(sb);
	}

}
