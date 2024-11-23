package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class No14713_앵무새 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			arr.add(new ArrayList<String>());
			for(String s : line) {
				arr.get(i).add(s);
			}
		}
		ArrayList<String> L =new ArrayList<>(Arrays.asList(br.readLine().split(" "))); 
		
		for(int i =0; i<L.size(); i++) {
			String word = L.get(i);
			boolean isRemove = false;
			for(ArrayList<String> ar : arr) {
				if(ar.size()> 0 && ar.get(0).equals(word)) {
					ar.remove(0);
					L.remove(i--);
					isRemove = true;
					break;
				}
				
			}
			if(!isRemove) {
				System.out.println("Impossible");
				System.exit(0);
			}
		}
		int size = 0;
		for(ArrayList<String> ar : arr) {
			size += ar.size();
		}
		if(L.size()==0 && size == 0 ) {
			System.out.println("Possible");
		}else {
			System.out.println("Impossible");
		}
		
	}

}
