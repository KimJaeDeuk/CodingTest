package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10815_숫자카드 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(binarySearch(arr,num)) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
			
		}
		System.out.println(sb);

	}

	private static boolean binarySearch(int[] arr, int num) {
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start<=end) {
			mid = (start+end)/2;
			
			if(arr[mid]==num) {
				return true;
			}else if(arr[mid] > num) {
				end = mid-1;
			}else {
				start = mid+1;
			}
			
		}
		
		return false;
	}

}
