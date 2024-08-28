import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		ArrayList<Integer> list = new ArrayList<>();
		for(int i=3; i>=1; i--) {
			String str = br.readLine();
			
			if(!str.equals("FizzBuzz") && !str.equals("Fizz") && !str.equals("Buzz")) {
				sb.append(check(Integer.parseInt(str)+(i)));
				break;
			}
		}
		
		System.out.println(sb);
	}

	private static String check(int num) {
		
		if(num %3 == 0 && num %5 == 0) {
			return "FizzBuzz";
		} else if(num % 3 == 0 && num%5 != 0) {
			return "Fizz";
		}  else if(num % 3 != 0 && num%5 == 0) {
			return "Buzz";
		} else {
			return String.valueOf(num);
		}
	}
}