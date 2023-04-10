package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1193_FindBunsu {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		int idx=1;
		int sum=0;
		int i=0;
		for( i=0; i<1000000; i++) {
			sum += i;
			if(sum>=X) break;
		}
		int x,y;
		
		if(i%2==0) {
			x = i; y=1;
			while(X<sum){
				x--;
				y++;
				sum--;
			}
			System.out.println(x+"/"+y);
		}
		else {
			x = 1; y = i;
			while (X<sum) {
				x++;
				y--;
				sum--;
			}
			System.out.println(x+"/"+y);
			
			}
			
		}
	}

