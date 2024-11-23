import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Tree{
		
		Node root;
		
		public void setRoot(Node root) {
			this.root = root;
		}

		// left 면 false, right 면 true
		public void findPlace(int num, boolean direction, Node parentNode) {
			
			while(true) {
				
				if((!direction&&parentNode.leftChild==null)){
					parentNode.leftChild = new Node(num);
					break;
				} else if(direction&&parentNode.rightChild == null) {
					parentNode.rightChild = new Node(num);
					break;
				}
				
				if(!direction) {
					Node leftNode = parentNode.leftChild;
					direction = leftNode.value < num;
					parentNode = leftNode;
				} else {
					Node rightNode = parentNode.rightChild;
					direction = rightNode.value < num;
					parentNode = rightNode;
				}
			}
		}
	}
	
	static class Node{
		
		int value;
		Node leftChild;
		Node rightChild;
		
		Node(int v) {
			this.value = v;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		Tree tree = new Tree();
		while( (line = br.readLine())!=null) {
			
			int num = Integer.parseInt(line);
			
			if(tree.root == null) {
				tree.setRoot(new Node(num));
			} else {
				
				tree.findPlace(num, tree.root.value < num, tree.root);
			}
		}
		
		dfs(tree.root);
		System.out.println(result.toString());
	}

	private static void dfs(Node currNode) {
		
		if(currNode == null) {
			return;
		}
		
		
		dfs(currNode.leftChild);
		dfs(currNode.rightChild);
		result.append(currNode.value).append("\n");
		
	}
	
}