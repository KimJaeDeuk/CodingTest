package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1544_사이클단어 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<String>();
	
		for(int i=0; i<n; i++) {
			String word = br.readLine();
			boolean check = false;
			if(list.isEmpty()) {
				list.add(word);
			}else {
				char c = word.charAt(0);
				for(String key : list) {
					
					for(int j=0; j<key.length(); j++) {
						
						if(key.charAt(j)==c && key.length() == word.length()) {
							String qlry=key.substring(j)+key.substring(0,j);
							if(qlry.equals(word)) {
								check = true;
								break;
							}
						}
						
						
					}
					if(check) break;
					
				}
				if(!check) list.add(word);
				
				
			}
			
		}
		System.out.println(list.size());
		 
		
		
	}

}
