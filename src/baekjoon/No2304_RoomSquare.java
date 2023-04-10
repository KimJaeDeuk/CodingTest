package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class No2304_RoomSquare {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Map<Integer,Integer> sortMap = new TreeMap<Integer,Integer>(map);
		
		int [][] arr = new int[N][2];
		int j=0;
		for(int i : sortMap.keySet()) {
			arr[j][0] = i;
			arr[j][1] = sortMap.get(i);
			j++;
		}
		int array=0;
		for(int i=0; i<N; i++) {
			j = i;
			while(arr[i][1]<arr[j][1] && j<N) {
				j++;
				
			} 
			array = (arr[j][0] - arr[i][0]) * arr[i][1];
			
		}
		
	}

}
