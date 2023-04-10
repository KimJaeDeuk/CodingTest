
public class Test {

	public static void main(String[] args) {
		int input = 1234567;
		
		
		System.out.println(reverseFromNum(input));
	}

	private static int reverseFromNum(int input) {
		int result = 0;
		int num = 1;
		while(input>0) {
			result *= 10;
			num *= 10;
			int inputA =  input % num;
			input -= inputA;
			while(inputA>=10) {
				inputA = inputA / 10;
			}
			result += inputA;
		}
		return result;
	}

}
