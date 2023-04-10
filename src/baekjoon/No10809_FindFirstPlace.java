package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No10809_FindFirstPlace {
	
	static String S ="";
	static HashMap<Character, Integer> map ;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		
		
		findWord(S);
		for(char s : map.keySet()) {
			System.out.print(map.get(s)+" " + s);
		}
	}

	private static void findWord(String word) {
		map = new HashMap<Character, Integer>();
		for(int i=0; i<26; i++) {
			map.put((char)(i+97), -1);
		}
		
		for(int i=0; i<word.length(); i++) {
			if(map.get(word.charAt(i)) == -1) {
				map.put(word.charAt(i), i);
			}
		}
		
		
	}

}
