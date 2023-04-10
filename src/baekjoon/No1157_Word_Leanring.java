package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collections;

public class No1157_Word_Leanring {
	static int max = 0;
	static Character maxWord='a';
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		word = word.toUpperCase();


		char a = findWord(word);
		System.out.println(a);

	}
	private static char findWord(String word) {
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();

		for(int i=0; i<word.length(); i++) {
			if(!map.containsKey(word.charAt(i))) {
				map.put(word.charAt(i), 1);
			}

			else {
				map.put(word.charAt(i), map.get(word.charAt(i))+1);
			}
		}

		for(Character a : map.keySet()) {
			if(max <map.get(a)) { 
				max = map.get(a);
				maxWord = a;
			}
		}
		for(Character a : map.keySet()) {
			if(maxWord != a && max == map.get(a))
				return '?';
		}
		return maxWord;
	}
}
