import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] check = new boolean[6][6];
		for(int i =0; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			check[a][b] = true;
			check[b][a] = true;
			
		}
		
		if(isFox(check)&& check[1][3] && check[1][4] && check[3][4]) {
			System.out.println("Wa-pa-pa-pa-pa-pa-pow!");
		}else {
			System.out.println("Woof-meow-tweet-squeek");
		}
	}

	private static boolean isFox(boolean[][] check) {
		
		for(int i=2; i<6; i+=3) {
			
			for(int j=1; j<6; j++) {
				
				if(i!=j && check[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
