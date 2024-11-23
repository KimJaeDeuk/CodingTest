package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No2990_단어검색 {
	
	static int N,M;
	static String[] db,search;
	static class Node {
		
		HashMap<Character,Node> childNodes = new HashMap<>();
		boolean endOfWords;
		
	}
	static int cnt = 0;
	static int leafCnt = 0;
	static class Trial{
		
		Node rootNode = new Node();
		
		void insertWord(String word) {
			Node node = this.rootNode;
			
			for(int i=0; i<word.length(); i++) {
				node = node.childNodes.computeIfAbsent(word.charAt(i), key -> new Node());
			}
			node.childNodes.put(' ', new Node());
			node = node.childNodes.get(' ');
			node.endOfWords = true;
		}

	}
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Trial tree = new Trial();
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			tree.insertWord(word);
		}
		
		M = Integer.parseInt(br.readLine());
		search = new String[M];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			
			int cnt = findCount(tree , str+" ");
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}


	private static int findCount(Trial tree, String string) {
		cnt = 0;
		
		dfs(tree.rootNode, string, 0);
		return cnt;
	}


	private static void dfs(Node node, String string, int idx) {
		
		int childSize = node.childNodes.size();
		for(Character c : node.childNodes.keySet()) {
			
			if(string.charAt(idx) == c) {
				
				cnt += (childSize );
				dfs(node.childNodes.get(c), string, idx+1);
			} else {
				leafCnt = 0;
				findLeaf(node.childNodes.get(c));
				cnt += leafCnt;
			}
			
		}
	}


	private static void findLeaf(Node node) {
		
		if(node.endOfWords) {
			leafCnt++;
			
		}
		
		
		for(Character key : node.childNodes.keySet()) {
			findLeaf(node.childNodes.get(key));
		}
		
	}


	
}
