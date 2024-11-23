import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		
		while(!(str = br.readLine()).equals("0 0 0")) {
			int arr[] = new int[3];
			String split[] = str.split(" ");
			arr[0] = Integer.parseInt(split[0]);
			arr[1] = Integer.parseInt(split[1]);
			arr[2] = Integer.parseInt(split[2]);
			
			Arrays.sort(arr);
			
			if(check(arr)) {
				sb.append("right");
			} else {
				sb.append("wrong");
			}
			sb.append("\n");
		}
		System.out.println(sb);	
	}


	private static boolean check(int[] arr) {
		
		if((int)Math.pow(arr[2], 2) ==  ((int)(Math.pow(arr[0], 2) + (int)(Math.pow(arr[1], 2)))) )  {
			return true;
		}
		
		return false;
	}
	
	
}
