package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
class Study{
    String subject;
    int min;
    int studyTime;
    public Study(String s, int m, int st){
        this.subject = s;
        this.min = m;
        this.studyTime = st;
    }
    public String toString(){
        return this.subject + " " + this.min + " " + this.studyTime;
    }
}
public class Lv2_과제진행하기 {
	
	public static void main(String[] args) throws Exception{
		String plans[][] = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
		
		Stack<Study> stack = new Stack<Study>();
        ArrayList<Study> list = new ArrayList<Study>();
      
        
        
        int len = plans.length;
        sort(plans);
        int idx = 0;
        
        for(int i=0; i<len; i++){
            String s = plans[i][0];
            String t_plit[] = plans[i][1].split(":");
            int time = Integer.parseInt(plans[i][2]);
            list.add( new Study(  s, Integer.parseInt(t_plit[0])*60+Integer.parseInt(t_plit[1]),time));
        }
        
        ArrayList<String> result = new ArrayList<String>();
        Study n = list.get(0);
        int now = list.get(0).min;
        while(list.size()!=0){
        	
        	Study next = list.get(idx);
        	if(now < next.min && !stack.isEmpty()) {
        		
        	}
        	if(n.min+n.studyTime <= next.min) {
        		now = next.min;
        		list.remove(idx);
        		result.add(n.subject);
        	}else {
        		
        	}
        	
        	
        }
        System.out.println(result);
        
        
        
       
        String[] answer = result.toArray(new String[len]);
        //return answer;
    }
    
    public static void sort(String[][] plans){
        Arrays.sort(plans, new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                return o1[1].compareTo(o2[1]);
            } 
        });
	}
}
