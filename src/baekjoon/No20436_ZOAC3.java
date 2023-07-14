package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class No20436_ZOAC3 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Character, Pos> left = new HashMap<Character, Pos>();
		HashMap<Character, Pos> right = new HashMap<Character,Pos>();
		setDefault(left, right);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		char l = st.nextToken().charAt(0);
		char r = st.nextToken().charAt(0);
		String line = br.readLine();
		
		int sec = 0;
		for(int i=0; i<line.length(); i++) {
			
			if(left.containsKey(line.charAt(i))) {	//left로 하는지
				Pos now = left.get(l);
				Pos after = left.get(line.charAt(i));
				
				sec += Math.abs(now.x-after.x) +  Math.abs(now.y-after.y);
				l = line.charAt(i);
			}else {
				Pos now = right.get(r);
				Pos after = right.get(line.charAt(i));
				
				sec += Math.abs(now.x-after.x) +  Math.abs(now.y-after.y);
				r = line.charAt(i);
			}
			sec++;
			
		}
		System.out.println(sec);
	}

	private static void setDefault(HashMap<Character, Pos> left, HashMap<Character, Pos> right) {
		left.put('q', new Pos(0,0));
		left.put('w', new Pos(0,1));
		left.put('e', new Pos(0,2));
		left.put('r', new Pos(0,3));
		left.put('t', new Pos(0,4));
		left.put('a', new Pos(1,0));
		left.put('s', new Pos(1,1));
		left.put('d', new Pos(1,2));
		left.put('f', new Pos(1,3));
		left.put('g', new Pos(1,4));
		left.put('z', new Pos(2,0));
		left.put('x', new Pos(2,1));
		left.put('c', new Pos(2,2));
		left.put('v', new Pos(2,3));
		right.put('y', new Pos(0,0));
		right.put('u', new Pos(0,1));
		right.put('i', new Pos(0,2));
		right.put('o', new Pos(0,3));
		right.put('p', new Pos(0,4));
		right.put('h', new Pos(1,0));
		right.put('j', new Pos(1,1));
		right.put('k', new Pos(1,2));
		right.put('l', new Pos(1,3));
		right.put('b', new Pos(2,-1));
		right.put('n', new Pos(2,0));
		right.put('m', new Pos(2,1));

	}

}
