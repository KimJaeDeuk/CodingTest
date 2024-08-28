import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	static class Info {
		int age;
		String name;
		int seq;
		Info(int a, String n, int s) {
			this.age = a;
			this.name= n;
			this.seq = s;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Info[] arr = new Info[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Info(Integer.parseInt(st.nextToken()), st.nextToken(), i);
		}
		
		Arrays.sort(arr, new Comparator<Info>() {
			
			@Override
			public int compare(Info o1, Info o2) {
				if(o1.age == o2.age) {
					return Integer.compare(o1.seq, o2.seq);
				}
				return Integer.compare(o1.age,o2.age);
			}
		});
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i].age).append(" ").append(arr[i].name).append("\n");
		}
		System.out.println(sb);
	}
}
