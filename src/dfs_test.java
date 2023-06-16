
public class dfs_test {
	static int[] arr = {1,2,3,4,5};
	public static void main(String[] args) {
		
		//순열 - Permutation (순서가 있어서 [1,2]와 [2,1]은 다름으로 처리)
		// 서로 다른 n개에서 r개를 뽑아서 정렬하는 경우의 수
		System.out.println("순열 - Permutation");
		Permutation(0,3,new boolean[5], new int[3]);
		
		System.out.println("중복 순열 - 중복 Permutation");
		Permutation(0,3 , new int[3]);
		//조합 - Combination (순서가 없어서 [1,2] 와 [2,1]은 같음으로 처리)
		System.out.println("조합 - Combination");
		Combination(0,0, new boolean[5]);
		System.out.println("중복 조합 - Combination");
		Combination(0,0, new int[3]);
	}

	private static void Permutation(int depth, int N, boolean[] bs, int[] out) {
		if(depth==N) {
			for(int i=0; i<N; i++)
				System.out.print(out[i]+" ");
			System.out.println();
			return;
		}
		for(int i=0; i<5; i++) {
			if(!bs[i]) {
				bs[i] = true;
				out[depth] = arr[i];
				Permutation(depth+1, N, bs, out);
				bs[i] = false;
			}
				
		}
	}

	private static void Permutation(int depth, int N, int[] out) {
		if(depth==N) {
			for(int i=0; i<N; i++)
				System.out.print(out[i]+" ");
			System.out.println();
			return;
		}
		for(int i=0; i<5; i++) {
			out[depth] = arr[i];
			Permutation(depth+1, N,out);	
		}
	}
	private static void Combination(int depth, int start, boolean[] visited) {
		
		if(depth==3) {
			for(int i=0; i<5; i++)
				if(visited[i])
					System.out.print(arr[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=start; i<5; i++) {
			if(!visited[i]) {
				visited[i] = true;
				Combination(depth+1, i+1, visited);
				visited[i] = false;
			}
			
			
		}
	}
	
	private static void Combination(int depth, int start, int[] out) {
		
		if(depth==3) {
			for(int i=0; i<out.length; i++)
					System.out.print(out[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=start; i<5; i++) {
			out[depth] = arr[i];
			Combination(depth+1, i, out);
			
			
		}
	}
}
