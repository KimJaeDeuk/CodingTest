package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class No1213_Pelindrom {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = br.readLine();
		HashMap<Character, Integer> pel = new HashMap<Character, Integer>();
		for(int i=0; i<name.length(); i++) {
			
			if(!pel.containsKey(name.charAt(i))) {
				pel.put(name.charAt(i), 1);
			}
			else {
				pel.put(name.charAt(i), pel.get(name.charAt(i)) + 1);
			}
			
		}
		Map<Character, Integer> pel_sort = new TreeMap<Character,Integer>(pel);
		int hol = 0;
		String answer ="";
		char holsu = 'a';
		for(char s : pel_sort.keySet())
		{
			if(pel_sort.get(s)%2==1) {
				hol++;
				holsu = s;
			}
			
			for(int i=0; i<pel_sort.get(s)/2; i++) {
				answer += s;
			}
			
			if(hol>1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}
		if(hol==1)
			answer += holsu;
		
		for(int i=name.length()/2 -1; i>=0; i--) {
			answer += answer.charAt(i); 
		}
		System.out.println(answer);
		
	}

}
