package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No4659_PasswordSpeaking {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while(true) {
			String s = br.readLine();
			if(s.equals("end"))
				break;
			
			if(checkPass(s)) {
				sb.append("<"+s+"> is acceptable.").append("\n");
			}else {
				sb.append("<"+s+"> is not acceptable.").append("\n");
			}
		}
		System.out.println(sb);

	}

	private static boolean checkPass(String copy) {
		boolean moeum = false;
		int seq = 0;
		boolean moja = true;	//자음 트루 모음 false
		char beforeword = 'Z';
		for(int i=0; i<copy.length(); i++) {
			if(beforeword == copy.charAt(i) && beforeword!='o' && beforeword!='e')
				return false;
			
			if(copy.charAt(i)=='a' || copy.charAt(i)=='e' || copy.charAt(i)=='i' || copy.charAt(i)=='o' || copy.charAt(i)=='u') {
				moeum = true;
				if(!moja) {
					if(++seq==3)
						return false;
				}else {
					seq = 1;
					moja = false;
				}
			}else {
				if(moja) {
					if(++seq == 3)
						return false;
				}else {
					seq = 1;
					moja = true;
				}
			}
			
			beforeword = copy.charAt(i);
		}
		if(moeum)
			return true;
		else
			return false;
	}

}
