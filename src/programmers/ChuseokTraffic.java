package programmers;

import java.math.BigDecimal;

public class ChuseokTraffic {

	public static void main(String[] args) {
		String[] lines = new String[2];
		lines[0] = "2016-09-15 01:00:04.002 2.0s";
		lines[1] = "2016-09-15 01:00:07.000 2s";
		int answer = 0;
		   int[] date = new int[lines.length];
	        int[] times = new int[lines.length];
	        for(int i=0; i<lines.length; i++){
	            String[] split = lines[i].split(" ");
	            String[] sec = split[1].split(":");
	            
	            date[i] = (Integer.parseInt(sec[0])*3600 + Integer.parseInt(sec[1])*60) * 1000 + Integer.parseInt(sec[2].substring(0,2)) * 1000 + Integer.parseInt(sec[2].substring(3,sec[2].length()));
	            String useTime =split[2].substring(0 , split[2].length()-1);
	            times[i] =  (int) ((Float.valueOf(useTime)) * 1000);
	        }
	        
	         for(int i=0; i<lines.length ;i++) {
	        		int cnt = 0;
	        		for(int j=0; j<lines.length; j++) {
	                    
	                       
	    			    if(date[j]-(times[j]-1) - date[i]  <=999 && date[i] <=date[j])
	    				    cnt++;
	    		    }
	        		answer = Math.max(answer, cnt);
	        }

	}

}
