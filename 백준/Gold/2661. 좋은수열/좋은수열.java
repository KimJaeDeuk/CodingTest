import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
static int n;
	static String max = "";
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(1);
			
		}
		
		dfs("", 0,0);
		System.out.println(max);
	}
	private static void dfs(String sb, int depth, int insertNum) {
		if(!max.equals("")) return;
		if(depth==n) {
			
			
				max = sb.toString();
			return; 
		}
		
		for(int i=1; i<=3; i++) {
			if(insertNum == i ) continue;
			if(check(sb+i))
				dfs(sb+i, depth+1, i);
			
		}
	}
	private static boolean check(String value) {
		
		for(int i=1;i<=value.length()/2;i++) {
			for(int j=0;j<=value.length()-i*2;j++) {
				if(value.substring(j,j+i).equals(value.substring(j+i,j+i*2))) return false;
			}
		}
		return true;
	}

}
