package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No4378_트ㅏㅊ {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine())!=null) {
			String words[] = line.split(" ");
			String keyBoard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
			for(int i= 0; i < words.length; i ++) {
				for(int j=0; j<words[i].length(); j++) {
					String c = String.valueOf(words[i].charAt(j));
					int idx = keyBoard.indexOf(c);
					sb.append(keyBoard.charAt(idx-1));
				}
				if(words.length-1 != i) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
		

}
