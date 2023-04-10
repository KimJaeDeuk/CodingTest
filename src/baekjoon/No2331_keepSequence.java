package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2331_keepSequence {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(A);
		int seq_num = A;
		while(true) {
			int sum=0;
			
			String s = String.valueOf(seq_num);
				
			
			while(seq_num!=0) {
				sum += Math.pow((seq_num%10), P);
				seq_num /= 10;
			}
			
			seq_num = sum;
			
			if(seq.contains(seq_num)) {
				System.out.println(seq.indexOf(seq_num));
				break;
			}
			seq.add(seq_num);
		}
		
	}

}
