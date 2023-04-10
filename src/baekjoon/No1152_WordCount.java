package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1152_WordCount {
	
	static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		String[] result = S.split(" ");
		for(int i=0; i<result.length; i++) 
			if(result[i].length()>0) cnt++;
			
		System.out.println(cnt);
	}

}
