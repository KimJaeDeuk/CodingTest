package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1920_수찾기 {
	//*todo*
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(binarySearch(arr, num)) {
				sb.append("1").append("\n");
			}else {
				sb.append("0").append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean binarySearch(int[] arr, int num) {
		int low = 0;
		int high = arr.length-1;
		
		int mid = 0;
		
		while(low<=high) {
			
			mid = (low+high)/2;
			
			if(arr[mid] == num) return true;
			else if(arr[mid] < num) {
				low = mid+1;
			}else
				high = mid-1;
				
		}
		return false;
	}

}
