package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class No2525_OvenWatch {

    public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringBuffer sb = new StringBuffer();
      StringTokenizer st = new StringTokenizer(bf.readLine()," ");
      int a = Integer.parseInt(st.nextToken());
	  int b = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(bf.readLine());
      
      System.out.println(cal_time(a,b,C)); 
    }

    
    
    private static String cal_time(int a, int b, int c) {
    	int h = c/60;
    	int m = c- (h*60);
    	
    	if(b+m >=60) { 
    		b = b+ m-60;
    		a++;
    	}
    	else { 
    		b+=m;
    	}
    	if(a+h>23) {
    		a=a+h-24;
    	}
    	else {
    		a+=h;
    	}
    	
    	String s = String.valueOf(a) + " " +String.valueOf(b);
		return s;
	}

}