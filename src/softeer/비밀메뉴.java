package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 비밀메뉴 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		
		String secret = br.readLine();
		String userMenu = br.readLine();
		
		if(userMenu.indexOf(secret) == -1) {
			System.out.println("normal");
		} else {
			System.out.println("secret");
		}
	}

}
