package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class rny_string {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		
		int k = 2;
		HashMap<String,HashSet<String>> map = new HashMap<String,HashSet<String>>();
		
		for(int i=0; i<report.length; i++) {
			String split[] = report[i].split(" ");
			HashSet<String> set = new HashSet<String>(); 
			if(!map.containsKey(split[1])) {
				set.add(split[0]);
				map.put(split[1], set);
			}else {
				set = map.get(split[1]);
				set.add(split[0]);
				map.put(split[1], set);
			}
			
		}
		int[] answer = new int[id_list.length];
		for(String key : map.keySet()) {
			HashSet<String> set = map.get(key);
			if(set.size()>=k) {
				
				for(String reporter : set) {
					for(int i=0; i<id_list.length; i++) {
						if(reporter.equals(id_list[i])) {
							answer[i]++;
							break;
						}
					}
				}
				
			}
		}
		
		for(int i=0; i<answer.length; i++)
		System.out.println(answer[i]);
	}

}


