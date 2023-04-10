package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No10773_Zero {
	
		public static void main(String[] args) throws Exception{

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int sum=0;
			int T = Integer.parseInt(br.readLine());
			ArrayList<Integer> aList = new ArrayList<Integer>();
			while(T-- > 0) {
				int a = Integer.parseInt(br.readLine());
				
				if(a==0) {
					if(aList.size()>0) {
						aList.remove(aList.size()-1);
					}
				}
				else {
					aList.add(a);
				}
			}
			for(int b : aList)
				sum+=b;
			System.out.println(sum);
		}
		
}
