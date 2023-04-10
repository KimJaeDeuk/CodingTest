package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2941_CroatiaAlphabet {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String[] cro_alp = {"c=", "c-","dz=","d-","lj","nj","s=","z="};
		for(int i=0; i<cro_alp.length; i++)
		s = s.replaceAll(cro_alp[i], "a");


		System.out.println(s.length());
	}

}
