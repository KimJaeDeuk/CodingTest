package samsung;

class Node {
	public int data;
	public Node prev;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class No6_기초SingleLinkedList연습_2 {
	
	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
	private Node head;
    
	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {
		head = new Node(0);
		nodeCnt = 0;
	}
	
	public void addNode2Head(int data) {
		Node newNode = getNode(data);
		newNode.next = head.next;
		head.next = newNode;
		newNode.prev = head;
	}

	public void addNode2Tail(int data) {
		Node newNode = getNode(data);
		Node nextNode = head;
		while(true) {
			if(nextNode.next==null) {
				nextNode.next = newNode;
				newNode.prev = nextNode;
				break;
			}
		}
		
	}

	public void addNode2Num(int data, int num) {
		Node newNode = getNode(data);
		Node nextNode = head;
		int n=0;
		
		while(true) {
			n++;
			
			if(n==num) {
				Node prevNode = nextNode.prev;
				prevNode.next = newNode;
				newNode.prev = prevNode;
				
				newNode.next = nextNode;
				nextNode.prev = newNode;
				
				break;
			}
			
			if(nextNode.next == null) break;
			
			nextNode = nextNode.next;
			
			
		}
		
	}
	
	public int findNode(int data) {
		Node nextNode = head.next;
		int n =1;
		while(true) {
			
			if(nextNode.data==data) {
				return n;
			}
			
			if(nextNode.next==null) {
				return -1;
			}
			
			nextNode = nextNode.next;
			n++;
		}
	}
	
	public void removeNode(int data) {
		Node nextNode = head.next;
		
		while(true) {
			
			if(nextNode.data==data) {
			
				if(nextNode.next==null) {
					nextNode.prev.next = null;
					
					return;
				}
				Node prevNode = nextNode.prev;
				
				prevNode.next = nextNode.next;
				nextNode.next.prev = prevNode;
				
				return;
			}
			
			if(nextNode.next== null) {
				return;
			}
			
			nextNode = nextNode.next;
		}
	}

	public int getList(int[] output) {
		Node nextNode = head.next;
		for(int i=0; i<nodeCnt; i++) {
			
			output[i] = nextNode.data;
			
			
			nextNode = nextNode.next;
		}
		
		return nodeCnt;
	}
	
	public int getReversedList(int[] output) {
		
		Node lastNode = head.next;
		
		while(lastNode.next!=null) {
			lastNode = lastNode.next;
		}
		for(int i=0; i<nodeCnt; i++) {
			
			output[i] = lastNode.data;
			
			
			lastNode = lastNode.prev;
		}
		return nodeCnt;
	}
}